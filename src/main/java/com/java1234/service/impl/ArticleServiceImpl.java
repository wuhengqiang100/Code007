package com.java1234.service.impl;

import com.java1234.entity.Article;
import com.java1234.repository.ArticleRepository;
import com.java1234.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> list(Article s_article,Integer page, Integer pageSize, Sort.Direction direction, String... properties) {

        Pageable pageable=new PageRequest(page,pageSize,direction,properties);
        Page<Article> pageArticle = articleRepository.findAll(new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (s_article != null) {
                    if (s_article.getState() != null) {
                        predicate.getExpressions().add(criteriaBuilder.equal(root.get("state"), s_article.getState()));
                    }
                }
                return predicate;
            }
        }, pageable);
        return pageArticle.getContent();
    }

    @Override
    public Long getTotal(Article s_article) {
        long count = articleRepository.count(new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate=criteriaBuilder.conjunction();
                if (s_article!=null){
                    if (s_article.getState()!=null){
                        predicate.getExpressions().add(criteriaBuilder.equal(root.get("state"),s_article.getState()));
                    }
                }
                return predicate;
            }
        });
        return count;
    }
}
