package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class News {
    @Id
    private int id;

    @Column
    private Integer behottime;

    @Column
    private String groupid;

    @Column
    private String tag;

    @Column
    private String abstractnews;

    @Column
    private String imageurl;

    @Column
    private String title;

    @Column
    private String displayurl;

    @Column
    private  Integer category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBehottime() {
        return behottime;
    }

    public void setBehottime(Integer behottime) {
        this.behottime = behottime;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAbstractnews() {
        return abstractnews;
    }

    public void setAbstractnews(String abstractnews) {
        this.abstractnews = abstractnews;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisplayurl() {
        return displayurl;
    }

    public void setDisplayurl(String displayurl) {
        this.displayurl = displayurl;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
