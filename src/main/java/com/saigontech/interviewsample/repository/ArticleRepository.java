package com.saigontech.interviewsample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saigontech.interviewsample.entity.Article;
import com.saigontech.interviewsample.entity.Author;

public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article>{

    @Query("select a from Article a where a.author.name= :#{#author.name} and a.author.login= :#{#author.login}")
    List<Article> findAllWrittenBy(@Param("author") Author author);

    @Query("select a.tags from Article a join a.tags where a.title= :title")
    List<String> findAllTagsOfArticle(@Param("title") String title);

    @Query("select a from Article a where (a.author.name= :#{#author.name} and a.author.login= :#{#author.login}) or (a.title= :title)")
    List<Article> findByAuthorOrTitle(Author author, String title);

    @Query("select a.author from Article a where a.title= :title")
    Optional<Author> findAuthorOfArticleByTitle(String title);
}
