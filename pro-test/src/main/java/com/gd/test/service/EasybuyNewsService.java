package com.gd.test.service;

import com.gd.test.entity.EasybuyNews;

import java.util.List;

/**
 * @DATA 2019-01-03 18:35
 * @Author zhangguowei  WeChat:17630376104
 * @Description TODO
 */
public interface EasybuyNewsService {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyNews record);

    EasybuyNews selectByPrimaryKey(Integer id);

    List<EasybuyNews> selectAll();

    int updateByPrimaryKey(EasybuyNews record);
}
