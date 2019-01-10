package com.java1234.repository;


import com.java1234.entity.ArcType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
* @Description:    资源类型repository接口
* @Author:         wuhq
* @CreateDate:     2019/1/10 20:33
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/10 20:33
* @UpdateRemark:   
* @Version:        
*/

public interface ArcTypeRespository extends JpaRepository<ArcType,Integer>,JpaSpecificationExecutor {
}
