package com.java1234.service.impl;

import com.java1234.entity.User;
import com.java1234.repository.UserRepository;
import com.java1234.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:    用户service实现类
* @Author:         wuhq
* @CreateDate:     2019/1/11 21:01
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/11 21:01
* @UpdateRemark:   
* @Version:        
*/

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
