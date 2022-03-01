package com.yr.springboot.demo05.service;

import com.yr.springboot.demo05.mybatis.mapper.Test05Mapper;
import com.yr.springboot.demo05.mybatis.pojo.Test05;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @moduleName: Test05Service
 * @description: 服务类，缓存测试
 * @author: 杨睿
 * @date: 2022-01-30 15:15
 **/
@Service
public class Test05Service {
    @Autowired
    Test05Mapper testMapper;

    /**
     * 插入用户，最后 Mybatis 会回填id，取结果 id 缓存用户
     * @param  record  插入的用户数据，无 id
     * @return record  返回 id 后的用户数据
     */
    @Transactional(rollbackFor = Exception.class)
    @CachePut(value = "redisCache", key = "'redis_user_' + #result.id")
    public Test05 insertTest05(Test05 record){
        testMapper.insert(record);
        return record;
    }


    /**
     * 根据 id 获取用户。取参数 id 缓存用户
     * @param  id      主键
     * @return Test05  用户实例
     */
    @Transactional(rollbackFor = Exception.class)
    @Cacheable(value = "redisCache", key = "'redis_user_' + #id")
    public Test05 getTest05(Long id){
        return testMapper.selectByPrimaryKey(id);
    }


    /**
     * 查询满足条件的用户实例，命中率低，不使用缓存
     * @param username  用户名
     * @param note      笔记
     * @return  List<Test05>
     */
    @Transactional(rollbackFor = Exception.class)
    public List<Test05> findUsers(String username, String note){
        return testMapper.findUsers(username, note);
    }


    /**
     * 更新数据后，更新缓存，如果 condition 配置项是结果返回为 null，不缓存。
     * @param  id        主键
     * @param  username  用户名
     * @return test05    更新后的用户实例
     */
    @Transactional(rollbackFor = Exception.class)
    @CachePut(value = "redisCache", condition = "#result != 'null'", key = "'redis_user_' + #id")
    public Test05 updateTest05(Long id, String username){
        // 此处调用 getTest05 方法，该方法的缓存注解失效
        Test05 test05 = this.getTest05(id);
        if (test05 == null){
            return null;
        }
        test05.setUsername(username);
        testMapper.updateByPrimaryKey(test05);
        return test05;
    }


    /**
     * 删除数据，同步删除缓存
     * @param id 主键
     * @return 删除结果
     */
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "redisCache", key = "'redis_user_' + #id", beforeInvocation = false)
    public int deleteTest05(Long id){
        return testMapper.deleteByPrimaryKey(id);
    }
}
