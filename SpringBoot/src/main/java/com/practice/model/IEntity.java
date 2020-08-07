package com.practice.model;

import java.io.Serializable;

public interface IEntity<T extends IEntity, ID extends Serializable> extends Serializable {
    /**
     * 获取主键
     *
     * @return 主键 id
     */
    ID getId();

    /**
     * 设置主键
     *
     * @param id 主键值
     * @return 实体 id
     */
    T setId(ID id);
}
