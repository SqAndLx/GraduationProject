package com.graduation.treeTest;

/**
 * 树结构的实体类
 */
public class TreeModel {
    private String id;
    private String mc;
    private String father;
    private Integer level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public TreeModel( String id, String mc, String father, Integer level) {
        this.id = id;
        this.mc = mc;
        this.father = father;
        this.level = level;
    }


}
