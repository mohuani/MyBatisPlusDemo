package com.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther mohuani
 * @create 2019-12-24 23:01
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1088248166370832385L);
        System.out.println("删除记录条数：" + rows);
    }

    /**
     * 构造where条件删除
     */
    @Test
    public void deleteByMap() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "刘明强5");
        columnMap.put("age", 31);

        int rows = userMapper.deleteByMap(columnMap);
        System.out.println("删除记录条数：" + rows);
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteBatchIds() {
        int rows = userMapper.deleteBatchIds(Arrays.asList(1209754139000852481L, 1209838254358319105L, 1209838329864204289L));
        System.out.println("删除记录条数：" + rows);
    }


    /**
     * 通过Lambda形式
     */
    @Test
    public void updateByWrapper4() {
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.gt(User::getAge, 35).lt(User::getAge, 40);
        int rows = userMapper.delete(lambdaQuery);
        System.out.println("影响记录条数：" + rows);
    }

}
