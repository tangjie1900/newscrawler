package com.demo.entity.toutiao;


import com.demo.entity.RequestAttributeEntity;

public class PCtoutiaoEntity  extends RequestAttributeEntity {

    private String own_webUrl = "https://www.toutiao.com/api/pc/feed/?category=news_tech&utm_source=toutiao&widen=1&max_behot_time=0&max_behot_time_tmp=0&tadrequire=true&as=A1E5FBB00FF88F5&cp=5B0F88B8AF554E1&_signature=hBsZVwAA3yEuNFnXpYgWFIQbGU";

    private String own_authority = "www.toutiao.com";

    private String own_cookie = "tt_webid=6561317460007650830; WEATHER_CITY=%E5%8C%97%E4%BA%AC; UM_distinctid=163b092554b2f7-04863b34112154-39614807-1fa400-163b092554cf51; tt_webid=6561317460007650830; uuid=\"w:43600235f568449da23c4e16bbf8451a\"; _ga=GA1.2.713319843.1527676101; _gid=GA1.2.982106075.1527676101; __tasessionId=bpkmqqevq1527735750958; CNZZDATA1259612802=1370307864-1527675568-https%253A%252F%252Fwww.baidu.com%252F%7C1527735469";

    private String own_refer = "https://www.toutiao.com/ch/%s/";

    private  String useragent="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36";

    {
        this.setWebUrl(own_webUrl);
        this.setCookie(own_cookie);
        this.setRefer(own_refer);
        this.setUseragent(useragent);
    }
}