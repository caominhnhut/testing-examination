package com.saigontech.interviewsample.assignment2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Author author;

    @Column(unique = true)
    private String title;

    private String content;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> tags = new ArrayList<>();

    public Article(Author author, String title){
        this.author = author;
        this.title = title;
    }

    public Article(){

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Author getAuthor(){
        return author;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public List<String> getTags(){
        return new ArrayList<>(tags);
    }

    public void addTag(String tag){
        tags.add(tag);
    }
}
