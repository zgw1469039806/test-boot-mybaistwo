package com.gd.test.mapper;

import com.gd.test.entity.EasybuyNews;
import org.springframework.stereotype.Component;

import java.util.List;

public interface EasybuyNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyNews record);

    EasybuyNews selectByPrimaryKey(Integer id);

    List<EasybuyNews> selectAll();

    int updateByPrimaryKey(EasybuyNews record);
}