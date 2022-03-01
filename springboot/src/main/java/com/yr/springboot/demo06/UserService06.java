package com.yr.springboot.demo06;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.yr.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @moduleName: UserService
 * @description: 测试服务类
 * @author: 杨睿
 * @date: 2022-02-09 14:37
 **/
@Service
public class UserService06 {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据 id 获取实例
     *
     * @param id 主键
     * @return 实例对象
     */
    public User getUser(Long id) {
        return mongoTemplate.findById(id, User.class);
    }

    /**
     * 根据传入的条件进行模糊查询
     *
     * @param name   用户名
     * @param note   用户备注
     * @param skip   跳过记录条数
     * @param limit  至多返回记录条数
     * @return  实例列表
     */
    public List<User> findUser(String name, String note, int skip, int limit) {
        /**
         * 利用 Criteria 构造查询条件
         * where 方法的参数设置为 “username”，即查询该参数，其值为 name
         * regex：即设置为 模糊查询。若是精准查询，则 regex 改为 is
         * and：代表连接字，表示同时满足。
         */
        Criteria criteria = Criteria.where("username").regex(name).and("note").regex(note);

        /**
         * 利用 Query 对查询结果进行预处理。
         * query：利用 criteria 构造查询条件。
         * limit：至多返回 limit 条数据。
         * skip：跳过 skip 条数据。
         */
        Query query = Query.query(criteria).limit(limit).skip(skip);

        List<User> userList = mongoTemplate.find(query, User.class);

        return userList;
    }

    /**
     * 插入对象
     *
     * @param user 实例对象
     */
    public void saveUser(User user) {
        /**
         * 在 MongoDB 中，以集合名：user 保存数据
         * 如果集合中存在 Id 相同的对象，则对该对象进行属性值的更新
         */
        mongoTemplate.save(user, "user");
    }

    /**
     * 根据 id 删除记录
     * @param id 主键
     * @return DeleteResult
     */
    public DeleteResult deleteUser(Long id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = Query.query(criteria);

        // 使用 DeleteResult 来保存删除结果，其中包含一个 deleteCount 属性，表明删除的条数
        DeleteResult result = mongoTemplate.remove(query, User.class);
        return result;
    }

    /**
     * 更新数据
     *
     * @param id        主键
     * @param username  用户名
     * @param note      备注
     * @return  UpdateResult
     */
    public UpdateResult updateUser(Long id, String username, String note) {
        // 确定要更新的记录
        Criteria criteria = Criteria.where("id").is(id);
        Query query = Query.query(criteria);

        // 设置要更新的字段与字段值
        Update update = Update.update("username", username);
        update.set("note", note);

        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);

        // 更新多个对象
        // UpdateResult result = mongoTemplate.updateMulti(query, update, User.class);

        return result;
    }
}
