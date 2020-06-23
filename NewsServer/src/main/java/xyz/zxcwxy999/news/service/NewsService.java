package xyz.zxcwxy999.news.service;

import xyz.zxcwxy999.news.entity.News;

public interface NewsService {
    /**
     * 增加一条新闻
     * @return
     */
    boolean addNews(News news);

    /**
     * 获取全部新闻
     * @return
     */
    News[] getAllNews();

    /**
     * 获取一条新闻
     * @return
     */
    News getOne(int nid);
}
