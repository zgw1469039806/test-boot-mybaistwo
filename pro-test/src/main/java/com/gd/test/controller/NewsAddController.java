package com.gd.test.controller;

import com.gd.test.entity.EasybuyNews;
import com.gd.test.service.EasybuyNewsService;
import com.gd.test.service.impl.EasybuyNewsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @DATA 2019-01-03 18:32
 * @Author zhangguowei  WeChat:17630376104
 * @Description TODO
 */
@Controller
@Api("新闻相关测试")
public class NewsAddController {


    @Autowired
    private EasybuyNewsServiceImpl easybuyNewsService;


    @ApiOperation(value = "插入一条新闻信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "title", value = "新闻标题", dataType = "String", required = true)
            , @ApiImplicitParam(name = "content", value = "新闻内容", dataType = "String", required = true)})
    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    public String addNews(@RequestParam String title, @RequestParam String content) {
        EasybuyNews easybuyNews = new EasybuyNews();
        easybuyNews.setTitle(title);
        easybuyNews.setContent(content);
        easybuyNews.setCreatetime("2018");
        int add = easybuyNewsService.insert(easybuyNews);
        if (add > 0) {
            return "redirect:news.html";
        }
        return null;

    }

    @ResponseBody
    @RequestMapping(value = "/selAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有新闻信息", notes = "所有信息")
    public List<EasybuyNews> selAll() {

        return easybuyNewsService.selectAll();
    }
    @GetMapping("/del")
    @ApiOperation(value = "根据id删除")
    public String del(@RequestParam Integer id){
        int delete=easybuyNewsService.deleteByPrimaryKey(id);
        if (delete>0){
            return "redirect:news.html";
        }
            return "删除失败";

    }


}
