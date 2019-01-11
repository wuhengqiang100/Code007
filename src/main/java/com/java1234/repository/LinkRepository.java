package com.java1234.repository;

import com.java1234.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @Description:    友情链接Repository
* @Author:         wuhq
* @CreateDate:     2019/1/11 15:17
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/11 15:17
* @UpdateRemark:   
* @Version:        
*/

public interface LinkRepository extends JpaRepository<Link,Integer>,JpaSpecificationExecutor<Link> {
}
