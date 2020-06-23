package xyz.zxcwxy999.news.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.zxcwxy999.news.entity.User;
import xyz.zxcwxy999.news.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public JSONObject login(@RequestParam String username, @RequestParam String password){
        boolean result=userService.login(username,password);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isok",result);
        return jsonObject;

    }

    @PostMapping("/register")
    public JSONObject register(@RequestBody User user){
        boolean result=userService.register(user);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isok",result);
        return jsonObject;

    }
}
