package com.mp;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.mp.dao.UserMapper;
import com.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @Description
 * @auther mohuani
 * @create 2019-12-24 23:01
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(26);
        user.setEmail("wtf2@baomidou.com");
        int rows = userMapper.updateById(user);
        System.out.println("影响记录条数：" + rows);
    }

    /**
     * 通过Wrapper形式
     */
    @Test
    public void updateByWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "李艺伟").eq("age", 28);
        User user = new User();
        user.setEmail("lyw2019@baomidou.com");
        user.setAge(29);
        int rows = userMapper.update(user, updateWrapper);
        System.out.println("影响记录条数：" + rows);
    }

    /**
     * 构造where条件的时候直接设置update的内容
     */
    @Test
    public void updateByWrapper3() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "李艺伟").eq("age", 29).set("age", 30);
        User user = new User();
        user.setEmail("lyw2019@baomidou.com");
        user.setAge(29);
        int rows = userMapper.update(user, updateWrapper);
        System.out.println("影响记录条数：" + rows);
    }

    /**
     * 通过Lambda形式
     */
    @Test
    public void updateByWrapper4() {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = Wrappers.lambdaUpdate();
        lambdaUpdateWrapper.eq(User::getName, "李艺伟").eq(User::getAge, 30).set(User::getAge, 31);

        int rows = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println("影响记录条数：" + rows);
    }

    /**
     * 通过Lambda形式
     */
    @Test
    public void updateByWrapper5() {
        boolean update = new LambdaUpdateChainWrapper<>(userMapper)
                .eq(User::getName, "李艺伟").eq(User::getAge, 31).set(User::getAge, 32).update();
        System.out.println(update);
    }
}
