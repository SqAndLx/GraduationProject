package com.graduation.mode;

import lombok.Data;

@Data
public class Loginer {
    /**
     * 用户账号
     */
    private String id;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户密角色
     */
    private String type;
}
