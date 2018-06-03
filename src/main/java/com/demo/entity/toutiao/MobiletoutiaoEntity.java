package com.demo.entity.toutiao;


import com.demo.entity.RequestAttributeEntity;

public class MobiletoutiaoEntity extends RequestAttributeEntity {

    private String own_webUrl = "https://m.toutiao.com/list/?tag=%s&ac=wap&count=20&format=json_raw&as=A145CBE0AF1994D&cp=5B0FD919A49D6E1&max_behot_time=%s&_signature=%s&i=%s";

    private String own_authority = "www.toutiao.com";

    private String own_cookie = "tt_webid=6561631186458772996; WEATHER_CITY=%E5%8C%97%E4%BA%AC; UM_distinctid=163b092554b2f7-04863b34112154-39614807-1fa400-163b092554cf51; tt_webid=6561631186458772996; uuid=\"w:43600235f568449da23c4e16bbf8451a\"; _ga=GA1.2.713319843.1527676101; _gid=GA1.2.982106075.1527676101; __tasessionId=bpkmqqevq1527735750958; CNZZDATA1259612802=1370307864-1527675568-https%253A%252F%252Fwww.baidu.com%252F%7C1527735469";

    private String own_refer = "https://m.toutiao.com/?w2atif=1&channel=%s";

    private String useragent = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1";

    {
        setWebUrl(own_webUrl);
        setCookie(own_cookie);
        setRefer(own_refer);
        setUseragent(useragent);
    }
}