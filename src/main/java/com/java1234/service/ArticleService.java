package com.java1234.service;

import com.java1234.entity.Article;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:    资源service接口
* @Author:         wuhq
* @CreateDate:     2019/1/10 21:54
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/10 21:54
* @UpdateRemark:   
* @Version:        
*/

public interface ArticleService {

    /**
     * 根据条件分页查询资源
     * @param s_article
     * @param page
     * @param pageSize
     * @param direction
     * @param properties
     * @return
     */
    public List<Article> list(Article s_article,Integer page, Integer pageSize, Sort.Direction direction,String...properties);

    /**
     * 根据条件查询总记录数
     * @param s_article
     * @return
     */
    public Long getTotal(Article s_article);

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    public Article get(Integer id);
}
