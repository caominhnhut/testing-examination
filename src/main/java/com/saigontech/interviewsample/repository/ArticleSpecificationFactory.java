package com.saigontech.interviewsample.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.saigontech.interviewsample.entity.Article;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class ArticleSpecificationFactory{

    public Specification<Article> allArticlesWithTag(String tag){
        return (root, query, cb) -> cb.and(root.join("tags").in(tag));
    }

    public Specification<Article> byTitle(String title){
        return new Specification<Article>(){
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb){
                return cb.equal(root.get("title"), title);
            }
        };
    }

    public Specification<Article> byTitlePart(String titlePart){
        return new Specification<Article>(){
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb){
                return cb.like(root.get("title"), "%"+titlePart+"%");
            }
        };
    }
}
