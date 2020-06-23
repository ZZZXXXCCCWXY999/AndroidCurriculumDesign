package com.example.newsclient.Model;

/**
 * @author MJ
 * @description:
 * @date :2020/6/14 21:57
 */
public class NewsData {
    private String newsTitle;
    private String newsDate;
    private String newsContext;
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsContext() {
        return newsContext;
    }

    public void setNewsContext(String newsContext) {
        this.newsContext = newsContext;
    }


}
