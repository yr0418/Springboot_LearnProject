package com.yr.springboot.demo06;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.yr.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @moduleName: UserController
 * @description: 测试控制类
 * @author: 杨睿
 * @date: 2022-02-09 15:36
 **/
@RestController
@RequestMapping(value = "user")
public class UserController06 {
    @Autowired
    UserService06 userService;

    @GetMapping(value = "getUser")
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @PutMapping(value = "save")
    public int save(@RequestBody User user) {
        userService.saveUser(user);
        return 1;
    }

    @DeleteMapping(value = "delete")
    public DeleteResult delete(Long id) {
        return userService.deleteUser(id);
    }

    @PostMapping(value = "update")
    public UpdateResult update(Long id, String username, String note) {
        return userService.updateUser(id, username, note);
    }
}
