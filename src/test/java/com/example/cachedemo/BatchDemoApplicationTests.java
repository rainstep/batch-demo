package com.example.cachedemo;

import com.example.cachedemo.entity.User;
import com.example.cachedemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mybatis")
//@ActiveProfiles("jpa")
public class BatchDemoApplicationTests {
    @Autowired
    private UserService userService;


    @Test
    public void contextLoads() throws InterruptedException {
        int count = 5000;
//        List<User> userList = generateUserList(count);
//        for (int i = 0; i < 3; i++) {
//            StopWatch stopWatch = new StopWatch();
//            stopWatch.start();
//            batchAdd(userList);
//            stopWatch.stop();
//            System.out.println(stopWatch.getTotalTimeSeconds());
//        }
        List<User> userList = userService.findLimit(count);

        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            for (User user : userList) {
                user.setUserName("aaa" + random.nextInt());
            }
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            int results = userService.batchUpdate(userList);
            stopWatch.stop();
            System.out.println(results);
            System.out.println(stopWatch.getTotalTimeSeconds());
            System.out.println();
            Thread.sleep(1000);
        }

    }


    private List<User> generateUserList(int count) {
        String userName = "test_user";
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setUserName(userName);
            userList.add(user);
        }
        return userList;
    }

    public void add(List<User> userList) {
        for (User user : userList) {
            userService.add(user);
        }
    }

    public void batchAdd(List<User> userList) {
        userService.batchInsert(userList);
    }

    public void update(List<User> userList) {
        for (User user : userList) {
            userService.update(user);
        }
    }

}
