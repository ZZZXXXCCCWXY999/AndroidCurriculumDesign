package xyz.zxcwxy999.news.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.zxcwxy999.news.entity.News;

@Mapper
public interface NewsDao {
    /**
     * 查询一条新闻
     * @param nid
     * @return
     */
    @Select("select * from news where nid=#{nid}")
     News getOneNews(int nid);

    /**
     * 创建一条新闻
     * @param news
     * @return
     */
    @Insert("insert into news (title,message,date) values (#{news.title},#{news.message},#{news.date})")
     int createOneNews(@Param("news") News news);

    /**
     * 获取所有新闻
     * @return
     */
    @Select("select * from news")
     News[] getAllNews();
}
