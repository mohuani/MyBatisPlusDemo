package com.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description
 * @auther mohuani
 * @create 2019-12-24 22:50
 */

@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Long managerId;

    private LocalDateTime createTime;


}
