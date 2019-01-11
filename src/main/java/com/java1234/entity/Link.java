package com.java1234.entity;

import javax.persistence.*;

/**
* @Description:    超链接实体
* @Author:         wuhq
* @CreateDate:     2019/1/11 15:14
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/11 15:14
* @UpdateRemark:   
* @Version:        
*/

@Entity
@Table(name = "t_link")
public class Link {

    @Id
    @GeneratedValue
    private Integer id;//编号

    @Column(length = 400)
    private String name;//名称

    @Column(length = 400)
    private String url;//地址

    private Integer sort;//排序

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
