package xyz.zxcwxy999.news.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.zxcwxy999.news.dao.NewsDao;
import xyz.zxcwxy999.news.entity.News;

import java.util.Date;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    NewsDao newsDao;
    /**
     * 增加一条新闻
     *
     * @param news
     * @return
     */
    @Override
    public boolean addNews(News news) {
        news.setDate(new Date());
        return newsDao.createOneNews(news)>0?true:false;
    }

    /**
     * 获取全部新闻
     *
     * @return
     */
    @Override
    public News[] getAllNews() {
        return newsDao.getAllNews();
    }

    /**
     * 获取一条新闻
     *
     * @param nid
     * @return
     */
    @Override
    public News getOne(int nid) {
        return newsDao.getOneNews(nid);
    }
}
