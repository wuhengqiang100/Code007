package com.java1234.repository;

import com.java1234.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

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

    /**
     * 根据用户名查找实体
     * @param userName
     * @return
     */
    @Query(value="select * from t_user where user_name=?1",nativeQuery = true)
    public User findByUserName(String  userName);

    /**
     * 根据邮箱查找实体
     * @param email
     * @return
     */
    @Query(value="select * from t_user where email=?1",nativeQuery = true)
    public User findByEmail(String email);

}
