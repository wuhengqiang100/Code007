package com.java1234.service.impl;

import com.java1234.entity.ArcType;
import com.java1234.repository.ArcTypeRespository;
import com.java1234.service.ArcTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
/**
* @Description:    资源类别service接口实现类
* @Author:         wuhq
* @CreateDate:     2019/1/10 20:38
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/10 20:38
* @UpdateRemark:   
* @Version:        
*/

@Service("arcTypeService")
public class ArcTypeServiceImpl implements ArcTypeService {

    @Autowired
    private ArcTypeRespository arcTypeRespository;

    @Override
    public List<ArcType> listAll(Sort.Direction direction, String... properties) {
        Sort sort=new Sort(direction,properties);
        return arcTypeRespository.findAll(sort);//根据sort来排序
    }
}
