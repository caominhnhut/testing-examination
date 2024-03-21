package com.saigontech.interviewsample.assignment2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.saigontech.interviewsample.assignment2.entity.Article;
import com.saigontech.interviewsample.assignment2.entity.Author;

public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article>{

    //@Query("select a from Article a where a.author.name= :#{#author.name} and a.author.login= :#{#author.login}")
    @Query("select a from Article a where a.author = ?1")
    List<Article> findAllWrittenBy(Author author);

    @Query("select t from Article a join a.tags t where a.title= ?1")
    List<String> findAllTagsOfArticle(String title);

    @Query("select a from Article a where (a.author= ?1) or (a.title= ?2)")
    List<Article> findByAuthorOrTitle(Author author, String title);

    @Query("select a.author from Article a where a.title= ?1")
    Optional<Author> findAuthorOfArticleByTitle(String title);
}
