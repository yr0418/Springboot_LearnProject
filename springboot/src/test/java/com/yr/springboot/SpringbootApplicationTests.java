package com.yr.springboot;

import com.yr.springboot.demo01.intercept.MyInterceptor;
import com.yr.springboot.demo01.proxy.ProxyBean;
import com.yr.springboot.demo01.service.HelloService;
import com.yr.springboot.demo01.service.HelloServiceImpl;
import com.yr.springboot.demo06.UserService06;
import com.yr.springboot.demo06.pojo.Role;
import com.yr.springboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootApplicationTests {
    @Test
    public void t1(){
        HelloService helloService = new HelloServiceImpl();

        // 获取代理对象，实现约定的流程。
        HelloService proxy= (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());

        // target 对象为 HelloServiceImpl，调用的方法为 sayHello。
        // 正常返回，afterReturning
        proxy.sayHello("zhangsan");

        System.out.println("**********name is null************");
        // 异常返回，afterThrowing
        proxy.sayHello(null);
    }

    @Autowired
    UserService06 userService06;

    @Test
    public void test2() {
        for (int i = 2; i < 10; i++) {
            Long id = Long.valueOf(i);
            String username = "user" + i;
            String note = "note" + i;

            List<Role> list = new ArrayList<Role>();
            Role role1 = new Role();
            role1.setId(Long.valueOf(i));
            role1.setNote("note"+i);
            role1.setRoleName("role"+i);
            list.add(role1);

            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setNote(note);
            user.setRoles(list);

            userService06.saveUser(user);
        }
    }
}
