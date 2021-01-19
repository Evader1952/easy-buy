package com.ebuy.controller;

import com.ebuy.pojo.News;
import com.ebuy.model.Response;
import com.ebuy.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (News)表控制层
 *
 * @author makejava
 * @since 2021-01-19 14:47:35
 */
@RestController
@RequestMapping("news")
public class NewsController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService newsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public News selectOne(Integer id) {
        return this.newsService.queryById(id);
    }


    @RequestMapping(value = "getNews", method = RequestMethod.GET)
    public Response<List<News>> getNews(HttpSession session) {
        return Response.ok(newsService.getAll());
    }

}