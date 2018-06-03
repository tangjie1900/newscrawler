package com.demo.service.impl;

import com.demo.dao.NewsMapper;
import com.demo.dao.NewsdetailMapper;
import com.demo.entity.RequestAttributeEntity;
import com.demo.entity.ToutiaoEntity;
import com.demo.entity.toutiao.NewsDetailEntity;
import com.demo.model.News;
import com.demo.model.Newsdetail;
import com.demo.service.NewsService;
import com.demo.utils.CrawlerUtils;
import com.demo.utils.StringEncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;


@Service
public class NewsServiceImpl implements NewsService {

    private CrawlerUtils crawlerUtils = new CrawlerUtils();

    private String toutiaoTemplate = "https://m.toutiao.com/i%s/";

    //最后一个behot_time  模拟翻动次数
    private int latestbehot_time = 0, like_huadong_times = 20;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsdetailMapper newsdetailMapper;

    @Override
    public void excuteParse() {
        LinkedList<RequestAttributeEntity> lists = ToutiaoEntity.getweburls();
        //不同分类
        for (int i = 9; i < lists.size(); i++) {
            parsesinfleWeb(lists.get(i), i);
            sleep(10);
        }
        System.out.println("all is done");
    }


    private void parsesinfleWeb(RequestAttributeEntity reqEntity, int index) {
        //模拟翻动20次
        //一个请求爬好之后 改变id 重新请求 模拟滚动
        String otherurl = "", originalweburl = reqEntity.getWebUrl();
        String uuidstr = UUID.randomUUID().toString().replaceAll("-", "");
        for (int i = 0; i < like_huadong_times; i++) {
            if (i == 0) {
                //第一次请求不带i
                otherurl = String.format(originalweburl, ToutiaoEntity.getCategorys()[index], 0, uuidstr, "");
            } else {
                otherurl = String.format(originalweburl, ToutiaoEntity.getCategorys()[index], latestbehot_time, uuidstr, latestbehot_time);
            }
            String webrefre = String.format(reqEntity.getRefer(), ToutiaoEntity.getCategorys()[index]);
            reqEntity.setWebUrl(otherurl);
            reqEntity.setRefer(webrefre);

            crawlerUtils.setRequestAttEntity(reqEntity);
            String webString = crawlerUtils.getHtml();
            String unicodeString = StringEncodingUtils.unicodeToString(webString);
            if (unicodeString != "")
                parseJson(unicodeString, index);
        }
    }


    /**
     * 解析请求返回的json 并插入数据库
     */
    public void parseJson(String unicodeString, int index) {
        try {
            JSONObject jsonObject = new JSONObject(unicodeString);
            jsonObject.getBoolean("has_more");
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject tempobjs = jsonArray.getJSONObject(i);
                String tag = parseJsonObjectString(tempobjs, "tag");
                if (tag.equals("ad")) {
                    continue;
                }

                int behot_time = tempobjs.getInt("behot_time");
                latestbehot_time = behot_time;

                String group_id = parseJsonObjectString(tempobjs, "group_id");
                String abstractnews = parseJsonObjectString(tempobjs, "abstract");
                String image_url = getimageurl(tempobjs);
                String title = parseJsonObjectString(tempobjs, "title");
                String display_url = parseJsonObjectString(tempobjs, "display_url");

                News news = new News();
                news.setBehottime(behot_time);
                news.setGroupid(group_id);
                news.setAbstractnews(abstractnews);
                news.setTag(tag);
                news.setImageurl(image_url);
                news.setTitle(title);
                news.setDisplayurl(String.format(toutiaoTemplate, group_id));
                news.setCategory(index);

                //爬完之后睡会吧
                sleep(10);

                Newsdetail newsdetail = parseNewsInfos(group_id);
                if (null == newsdetail) return;
                insertNews(news, newsdetail, group_id);

                sleep(10);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return;
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void insertNews(News news, Newsdetail newsdetail, String groupid) {
        try {
            newsMapper.insert(news);
            newsdetailMapper.insert(newsdetail);
        } catch (Exception ex) {
            System.out.println(String.format("news 插入失败 %s %s %s", news.getGroupid(), news.getDisplayurl(), news.getTitle()));
            System.out.println(String.format("news 插入失败 %s %s %s", newsdetail.getGroupid(), groupid, newsdetail.getTitle()));
        }
    }


    public Newsdetail parseNewsInfos(String groupid) {
        CrawlerUtils newsinfo = new CrawlerUtils();
        newsinfo.setRequestAttEntity(new NewsDetailEntity(groupid));
        String webString = newsinfo.getHtml();
        String unicodeString = webString != "" ? StringEncodingUtils.unicodeToString(webString) : "";
        if (unicodeString != "") {
            return praseNewsDetail(unicodeString, groupid);
        } else
            return null;
    }

    private Newsdetail praseNewsDetail(String unicodeString, String groupid) {
        try {
            JSONObject jsonObject = new JSONObject(unicodeString);
            if (!jsonObject.has("data")) {
                return null;
            }
            JSONObject dataObject = jsonObject.getJSONObject("data");
            String content = parseJsonObjectString(dataObject, "content");
            int comment_count = dataObject.has("comment_count") ? dataObject.getInt("comment_count") : 0;
            int publish_time = dataObject.has("publish_time") ? dataObject.getInt("publish_time") : 0;

            String title = parseJsonObjectString(dataObject, "title");
            String source = parseJsonObjectString(dataObject, "source");

            String sourceimage = "";
            if (dataObject.has("media_user") && dataObject.getJSONObject("media_user").has("avatar_url")) {
                sourceimage = dataObject.getJSONObject("media_user").getString("avatar_url");
            }

            Newsdetail newsdetail = new Newsdetail();
            newsdetail.setGroupid(groupid);
            newsdetail.setTitle(title);

            StringBuffer sb = new StringBuffer();
            sb.append("<div id=\"boxfather\"><div><h1>" + newsdetail.getTitle() + "</h1></div>");
            sb.append(content);
            sb.append("</div>");

            newsdetail.setContent(sb.toString());
            newsdetail.setPublishtime(publish_time);
            newsdetail.setNewssource(source);
            newsdetail.setCommentcount(comment_count);
            newsdetail.setSourceimage(sourceimage);
            return newsdetail;
        } catch (JSONException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    /**
     * 获取属性的值 要判断该json对象有没有该键值 存在该键值 取value 不存在返回“”
     */
    private String parseJsonObjectString(JSONObject jsonObject, String key) {
        String value = "";
        try {
            if (jsonObject.has(key)) {
                value = jsonObject.getString(key);
            }
        } catch (JSONException ex) {
            System.out.println(ex.toString());
        }
        return value;
    }

    /**
     * 获取图片地址
     */
    private String getimageurl(JSONObject jsonObject) {
        String value = "", key = "image_list";
        try {
            if (jsonObject.has("image_url")) {
                value = jsonObject.getString("image_url");
            } else if (jsonObject.has(key)) {
                JSONArray arrs_json = jsonObject.getJSONArray(key);
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < arrs_json.length(); i++) {
                    String urls = arrs_json.getJSONObject(i).getString("url");
                    sb.append(urls);
                    sb.append(';');
                }
                value = sb.toString();
                if (value != "" && value.length() >= 1) {
                    value = value.substring(0, value.length() - 1);
                }
            }
        } catch (JSONException ex) {
            System.out.println(ex.toString());
        }
        return value;
    }

    /**
     * 请求要间隔一段时间 反爬虫
     */
    private void sleep(int sencods) {
        try {
            Thread.sleep(sencods * 1000);
        } catch (Exception ex) {

        }
    }

}
