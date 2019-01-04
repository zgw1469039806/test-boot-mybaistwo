package com.gd.test.service.impl;

import com.gd.test.entity.EasybuyNews;
import com.gd.test.mapper.EasybuyNewsMapper;
import com.gd.test.service.EasybuyNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @DATA 2019-01-03 18:36
 * @Author zhangguowei  WeChat:17630376104
 * @Description TODO
 */
@Service
public class EasybuyNewsServiceImpl implements EasybuyNewsService {

    @Autowired
    private EasybuyNewsMapper easybuyNewsMapper;


    //    注入redistemplate
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return easybuyNewsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(EasybuyNews record) {
        return easybuyNewsMapper.insert(record);
    }

    @Override
    public EasybuyNews selectByPrimaryKey(Integer id) {
        return easybuyNewsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<EasybuyNews> selectAll() {

        RedisSerializer redisSerializer=new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        //查询缓存
       List<EasybuyNews> list= (List<EasybuyNews>) redisTemplate.opsForValue().get("allNews");
          if (list==null){
              System.out.println("--------------------存入redis--------------------");
              //缓存为空查询数据库
              list= easybuyNewsMapper.selectAll();
              //查询出来的数据放入redis
              redisTemplate.opsForValue().set("allNews",list);
          }
        return list;
    }

    @Override
    public int updateByPrimaryKey(EasybuyNews record) {
        return easybuyNewsMapper.updateByPrimaryKey(record);
    }
}
