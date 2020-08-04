package com.practice.bean.Entity;

import com.practice.model.IEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "备注")
@Table(name = "t_bean")
public class BeanEntity implements IEntity<BeanEntity, String> {

    // 序列化
    private static final long serialVersionUID = 3762621862446149927L;

    /**
     * 主键
     */
    @Id
    @Column(name = "c_bh")
    @ApiModelProperty(value = "编号")
    private String id;


    @Column(name = "c_xxx")
    @ApiModelProperty(value = " xxx")
    private String xx;
}
