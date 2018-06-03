package com.demo.model;

public class Newsdetail {

    private int id;

    private String groupid;

    private String title;

    private String content;

    private Integer publishtime;

    private String newssource;

    private Integer commentcount;

    private String sourceimage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Integer publishtime) {
        this.publishtime = publishtime;
    }

    public String getNewssource() {
        return newssource;
    }

    public void setNewssource(String newssource) {
        this.newssource = newssource;
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    public String getSourceimage() {
        return sourceimage;
    }

    public void setSourceimage(String sourceimage) {
        this.sourceimage = sourceimage;
    }
}
