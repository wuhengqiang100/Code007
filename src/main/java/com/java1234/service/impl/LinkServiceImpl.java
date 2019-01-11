package com.java1234.service.impl;

import com.java1234.entity.Link;
import com.java1234.repository.LinkRepository;
import com.java1234.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    /**
     *  查询所有的友情链接
     * @param direction
     * @param properties
     * @return
     */
    @Override
    public List<Link> listAll(Sort.Direction direction, String... properties) {
        Sort sort=new Sort(direction,properties);
        return linkRepository.findAll(sort);
    }
}
