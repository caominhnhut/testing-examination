package com.saigontech.interviewsample;

import java.util.Optional;

import com.saigontech.interviewsample.assignment1.service.Assignment1Service;
import com.saigontech.interviewsample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;

import com.saigontech.interviewsample.assignment2.entity.Article;
import com.saigontech.interviewsample.assignment2.entity.Author;
import com.saigontech.interviewsample.assignment2.repository.ArticleRepository;
import com.saigontech.interviewsample.assignment2.repository.ArticleSpecificationFactory;

@SpringBootApplication
public class InterviewSampleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(InterviewSampleApplication.class, args);
	}

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ArticleSpecificationFactory articleSpecificationFactory;

	@Autowired
	private PersonService service;

	@Autowired
	private Assignment1Service assignment1Service;

	@Override
	public void run(String... args) throws Exception{

//		assignment1Service.persitAppUser();
//		assignment1Service.persitPerson();

		//initiate();
		findAllWrittenBy();
		findAllTagsOfArticle();
		findByAuthorOrTitle();
		findAuthorOfArticleByTitle();

		findAllByTitle();
		findAllByTitlePart();
		findAllArticlesWithTag();

//		Person person = new Person();
//		person.setFirstName("Nhut");
//		service.addPerson(person);
//		service.addPet(person.getId(), "tien");
	}

	private void findAllByTitlePart(){
		System.out.println("#findAllByTitlePart");
		Specification<Article> specification = articleSpecificationFactory.byTitlePart("Book");
		articleRepository.findAll(specification).forEach(article -> System.out.println(article.getTitle()));
	}

	private void findAllByTitle(){
		System.out.println("#findAllByTitle");
		Specification<Article> specification = articleSpecificationFactory.byTitle("Book#1");
		articleRepository.findAll(specification).forEach(article -> System.out.println(article.getTitle()));
	}

	private void findAllArticlesWithTag(){
		Specification<Article> specification = articleSpecificationFactory.allArticlesWithTag("tag1");
		articleRepository.findAll(specification).forEach(article -> System.out.println(article.getTitle()));
	}

	private void findAuthorOfArticleByTitle(){
		System.out.println("#findAuthorOfArticleByTitle");
		Optional<Author> optAuthor = articleRepository.findAuthorOfArticleByTitle("Book#1");
		if(optAuthor.isPresent()){
			Author author = optAuthor.get();
			System.out.println("Author name: "+author.getName());
			System.out.println("Author login: "+author.getLogin());
		}
	}

	private void findByAuthorOrTitle(){
		System.out.println("#findByAuthorOrTitle");
		Author author = new Author("Tom", "tom@gmail.com");
		articleRepository.findByAuthorOrTitle(author, "Book#3").forEach(a -> System.out.println(a.getTitle()));
	}

	private void findAllTagsOfArticle(){
		System.out.println("#findAllTagsOfArticle");
		articleRepository.findAllTagsOfArticle("Book#1").forEach(System.out::println);
	}

	private void findAllWrittenBy(){
		System.out.println("#findAllWrittenBy");
		Author author = new Author("Tom", "tom@gmail.com");
		articleRepository.findAllWrittenBy(author).forEach(a -> System.out.println(a.getTitle()));
	}

	private void initiate(){

		Author author1 = new Author("Tom", "tom@gmail.com");

		Article article = new Article(author1, "Book#1");
		article.setContent("Hello Spring");
		article.addTag("tag1");
		article.addTag("tag2");

		Article article1 = new Article(author1, "Book#2");
		article1.setContent("Hello JPA");
		article1.addTag("tag1");
		article1.addTag("tag2");
		article1.addTag("tag3");

		Author author2 = new Author("Jay", "jay@gmail.com");
		Article article2 = new Article(author2, "Book#3");
		article2.setContent("Hello Security");
		article2.addTag("tag1");
		article2.addTag("tag2");

		articleRepository.save(article);
		articleRepository.save(article1);
		articleRepository.save(article2);
	}
}
