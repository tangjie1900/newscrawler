package com.demo.entity;

import java.util.LinkedList;

public class WebNewEntity {
    private boolean has_more;

    private String message;

    private LinkedList<RealTimeNewsEntity> data;

    public boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LinkedList<RealTimeNewsEntity> getData() {
        return data;
    }

    public void setData(LinkedList<RealTimeNewsEntity> data) {
        this.data = data;
    }
}

