package com.ebuy.service.impl;

import com.ebuy.mapper.NewsMapper;
import com.ebuy.pojo.News;
import com.ebuy.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (News)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 14:47:34
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public News queryById(Integer id) {
        return this.newsMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<News> queryAllByLimit(int offset, int limit) {
        return this.newsMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News insert(News news) {
        this.newsMapper.insert(news);
        return news;
    }

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News update(News news) {
        this.newsMapper.update(news);
        return this.queryById(news.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.newsMapper.deleteById(id) > 0;
    }


    @Override
    public List<News> getAll() {
        return  newsMapper.queryAll(null);
    }
}