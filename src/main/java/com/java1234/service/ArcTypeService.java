package com.java1234.service;

import com.java1234.entity.ArcType;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
* @Description:    资源类别service接口
* @Author:         wuhq
* @CreateDate:     2019/1/10 20:34
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/10 20:34
* @UpdateRemark:   
* @Version:        
*/

public interface ArcTypeService {

    /**
     * 查询所有资源类别,并排序
     * @param direction
     * @param properties
     * @return
     */
    public List<ArcType> listAll(Sort.Direction direction, String...properties);
}
