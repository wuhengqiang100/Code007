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
}
