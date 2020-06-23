package xyz.zxcwxy999.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping
    public String index(){
        return "index";
    }
    @GetMapping("/")
    public String index01(){
        return "index";
    }
}
