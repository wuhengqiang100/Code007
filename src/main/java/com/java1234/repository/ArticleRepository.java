package com.java1234.repository;

import com.java1234.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
/**
* @Description:    资源Repository接口
* @Author:         wuhq
* @CreateDate:     2019/1/10 21:52
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/10 21:52
* @UpdateRemark:   
* @Version:        
*/

public interface ArticleRepository extends JpaRepository<Article,Integer>,JpaSpecificationExecutor<Article> {

}
