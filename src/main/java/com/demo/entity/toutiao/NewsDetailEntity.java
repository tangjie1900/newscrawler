package com.demo.entity.toutiao;

import com.demo.entity.RequestAttributeEntity;

import java.util.UUID;

public class NewsDetailEntity extends RequestAttributeEntity {

    public NewsDetailEntity(String groupid) {
        own_webUrl = String.format(own_webUrl, groupid, UUID.randomUUID().toString().replaceAll("-", ""), groupid);
        //own_webUrl = String.format(own_webUrl, groupid);
        own_refer = String.format(own_refer, groupid);

        setWebUrl(own_webUrl);
        setCookie(own_cookie);
        setRefer(own_refer);
        setUseragent(useragent);
    }


    private String own_webUrl = "https://m.toutiao.com/i%s/info/?_signature=%s&i=%s";

	//private String own_webUrl = "https://m.toutiao.com/i%s/info/";

	private String own_authority = "m.toutiao.com";

	private String own_cookie = "csrftoken=bf1493fb771dea629bea1137ae5bfe0f; tt_webid=6561631186458772996; W2atIF=1; _ba=BA0.2-20180531-51225-S3EjMusMuT9NRRPnoRsC; _ga=GA1.2.1107883043.1527748813; _gid=GA1.2.668063106.1527748813; UM_distinctid=163b4fa9d8652c-09c07443ab6db1-39614807-1fa400-163b4fa9d87ce6; __tasessionId=j3amgcs6r1527815251475";

	private String own_refer = "https://m.toutiao.com/i%s/";

	private String useragent = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1";


//    private String own_webUrl = "https://m.toutiao.com/i%s/info/";
//
//    private String own_authority = "m.toutiao.com";
//
//    private String own_cookie = "csrftoken=c0825ed09a377fdda38b1f24444f5409; tt_webid=6562504313721095684; __tasessionId=oy14jsjb21527952104853; _ga=GA1.2.1964827535.1527952106; _gid=GA1.2.308403938.1527952106; _ba=BA0.2-20180602-51225-MM0A1BQmqXXLce8eBb2k; OUTFOX_SEARCH_USER_ID_NCOO=1197610544.5725462; UM_distinctid=163c10b61c3453-0bb3fccd90f083-39614807-1fa400-163c10b61c4149; uuid=\"w:2302bf8397064a5c91d94782bbb40f69\"; W2atIF=1; ___rl__test__cookies=1527952802854";
//
//    private String own_refer = "https://m.toutiao.com/i%s/";
//
//    private String useragent = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1";

}
