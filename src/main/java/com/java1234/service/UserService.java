package com.java1234.service;

import com.java1234.entity.User;

/**
* @Description:    用户service接口类
* @Author:         wuhq
* @CreateDate:     2019/1/11 20:59
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/11 20:59
* @UpdateRemark:   
* @Version:        
*/

public interface UserService {

    /**
     * 添加或者修改用户信息
     * @param user
     */
    public void save(User user);

    /**
     * 根据用户名查找实体
     * @param userName
     * @return
     */
    public User findByUserName(String userName);

    /**
     * 根据邮箱查找用户实体
     * @param email
     * @return
     */
    public User findByEmail(String email);
}
