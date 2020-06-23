package xyz.zxcwxy999.news.service;

import xyz.zxcwxy999.news.entity.User;

public interface UserService {
    /**
     * 登录
     * @return
     */
    boolean login(String username,String password);

    /**
     * 注册
     * @return
     */
    boolean register(User user);
}
