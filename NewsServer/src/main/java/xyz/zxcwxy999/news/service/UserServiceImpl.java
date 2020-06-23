package xyz.zxcwxy999.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.zxcwxy999.news.dao.UserDao;
import xyz.zxcwxy999.news.entity.User;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean login(String username, String password) {
        User user=userDao.getOne(username);
        if (user==null)return false;
        if(user.getPassword().equals(password))return true;
        return false;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        if(user.getUsername().equals(userDao.getOne(user.getUsername()))){
            return false;
        }
        return userDao.createOne(user)>0?true:false;
    }
}
