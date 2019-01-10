package com.java1234.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
* @Description:    类别实体
* @Author:         wuhq
* @CreateDate:     2019/1/10 20:24
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/10 20:24
* @UpdateRemark:   
* @Version:        
*/
@Entity
@Table(name="t_arcType")
public class ArcType {

    @Id
    @GeneratedValue
    private Integer id;//编号

    @NotEmpty(message = "请输入类别名称")
    @Column(length=100)
    private String name;//名称

    @Column(length=1000)
    private String remark;//描述

    private Integer sort;//排序(从小到大排序 )

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
