package xyz.zxcwxy999.news.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import xyz.zxcwxy999.news.entity.User;

@Mapper
public interface UserDao {
    /**
     * 查询一个用户
     *
     * @param username
     * @return
     */
    @Select("select * from user where username=#{usernmae}")
     User getOne(String username);

    /**
     * 创建一个用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user (username,password) values (#{user.username},#{user.password})")
     int createOne(@Param("user") User user);
}
