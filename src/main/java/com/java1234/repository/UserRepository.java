package com.java1234.repository;

import com.java1234.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
* @Description:    用户repository接口类
* @Author:         wuhq
* @CreateDate:     2019/1/11 20:58
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/11 20:58
* @UpdateRemark:   
* @Version:        
*/

public interface UserRepository extends JpaRepository<User,Integer> ,JpaSpecificationExecutor<User>{
}
