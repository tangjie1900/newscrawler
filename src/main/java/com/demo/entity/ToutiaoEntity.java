package com.demo.entity;


import com.demo.entity.toutiao.MobiletoutiaoEntity;

import java.util.LinkedList;
import java.util.List;

public class ToutiaoEntity {

    static {
        categorys = new String[]{"news_tech", "news_entertainment", "news_history","news_sports", "news_game",
                                "news_car", "news_world","news_finance", "funny", "news_military", "news_travel", "news_discovery","news_fashion", "news_hot"};

    }

    /**
     * 分类
     */
    private static String[] categorys;

    public static String[] getCategorys() {
        return categorys;
    }

    public static LinkedList<RequestAttributeEntity> getweburls() {
        LinkedList<RequestAttributeEntity> lists = new LinkedList<RequestAttributeEntity>();
        for (int i = 0; i < categorys.length; i++) {
            RequestAttributeEntity requestAttributeEntity = new MobiletoutiaoEntity();
            lists.add(requestAttributeEntity);
        }
        return lists;
    }
}
