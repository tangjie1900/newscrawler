package com.demo.controller;

import com.demo.service.NewsService;
import com.demo.utils.CrawlerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public String getHello() {
        newsService.excuteParse();
        return "";
    }

    @GetMapping("/getsome")
    public void getvalue() {
        String json = new CrawlerUtils().getHtml(" http://test.jinyoujf.com:8080/newsapi/getNewsList?category=1&pageCount=2");
        System.out.println(45);
    }

}
