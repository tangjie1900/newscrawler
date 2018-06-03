package com.demo.utils;


import com.demo.entity.RequestAttributeEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CrawlerUtils {

    private String authority;

    private String cookie;

    private String refer;

    private String useragent;

    private RequestAttributeEntity requestAttEntity;

    public void setRequestAttEntity(RequestAttributeEntity requestAttEntity) {
        this.requestAttEntity = requestAttEntity;
        this.cookie = requestAttEntity.getCookie();
        this.refer = requestAttEntity.getRefer();
        this.useragent = requestAttEntity.getUseragent();
    }

    public String getHtml() {
        return crawerweb(requestAttEntity.getWebUrl());
    }

    public String getHtml(String strWebUrl) {
        return crawerweb(strWebUrl);
    }

    private String crawerweb(String strWebUrl) {
        HttpURLConnection httpURLConnection = null;
        InputStreamReader input = null;
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(strWebUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            httpURLConnection.setRequestProperty("accept", " text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            httpURLConnection.setRequestProperty("accept-encoding", " utf-8");
            httpURLConnection.setRequestProperty("accept-language", " utf-8");
            httpURLConnection.setRequestProperty("content-type", " application/x-www-form-urlencoded");

            httpURLConnection.setRequestProperty("cookie", " " + this.cookie);
            httpURLConnection.setRequestProperty("referer", " " + this.refer);
            httpURLConnection.setRequestProperty("user-agent", " " + this.useragent);
            httpURLConnection.setRequestProperty("x-requested-with", " XMLHttpRequest");

            //发送POST请求必须设置如下两行
//            httpURLConnection.setDoOutput(true);
//            httpURLConnection.setDoInput(true);

            input = new InputStreamReader(httpURLConnection.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return "";
        } finally {
            if (httpURLConnection != null)
                httpURLConnection.disconnect();
        }
    }
}
