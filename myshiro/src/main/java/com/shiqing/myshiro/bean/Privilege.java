package com.shiqing.myshiro.bean;

import lombok.Data;

@Data
public class Privilege {

    private String cid;
    private String privilegename;
    private String parentid;
    private int isable;
    private int sort;
    private String remark;
}
