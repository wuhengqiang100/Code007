package com.java1234.service;

import com.java1234.entity.Link;
import com.java1234.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
* @Description:    友情链接service接口
* @Author:         wuhq
* @CreateDate:     2019/1/11 15:18
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/11 15:18
* @UpdateRemark:   
* @Version:        
*/

public interface LinkService {

    /**
     * 查询所有友情链接
     * @param direction
     * @param properties
     * @return
     */
    public List<Link> listAll(Sort.Direction direction,String...properties);

}
