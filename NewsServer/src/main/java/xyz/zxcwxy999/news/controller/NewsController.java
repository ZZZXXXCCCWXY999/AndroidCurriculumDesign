package xyz.zxcwxy999.news.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.zxcwxy999.news.entity.News;
import xyz.zxcwxy999.news.service.NewsService;

@RestController
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping("/news/{id}")
    public News getOne(@PathVariable("id")int nid){
        return newsService.getOne(nid);
    }

    @GetMapping("/news")
    public JSONObject getAll(){
        News[] news= newsService.getAllNews();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("object",news);
        return jsonObject;
    }

    @PostMapping("/news/add")
    public JSONObject add(@RequestBody News news){
        boolean result=newsService.addNews(news);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isok",result);
        return jsonObject;

    }
}
