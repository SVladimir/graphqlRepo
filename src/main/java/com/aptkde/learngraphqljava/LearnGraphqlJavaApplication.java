package com.aptkde.learngraphqljava;

import com.aptkde.learngraphqljava.model.Author;
import com.aptkde.learngraphqljava.model.Book;
import com.aptkde.learngraphqljava.repository.AuthorRepository;
import com.aptkde.learngraphqljava.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LearnGraphqlJavaApplication implements ApplicationRunner {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LearnGraphqlJavaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Book book=new Book("Learn GraphQL","222:2222:3333");
		Author eve =new Author("Eveee");
		Author alex= new Author("Alex");
		book.addAuthor(eve);
		book.addAuthor(alex);
		authorRepository.saveAll(Arrays.asList(eve,alex));
		bookRepository.save(book);

		Book book1=new Book("Learn GraphQL1","111:111:1111");
		Author eve1 =new Author("Evee1");
		Author alex1= new Author("Alex1");
		book.addAuthor(eve1);
		book.addAuthor(alex1);
		authorRepository.saveAll(Arrays.asList(eve1,alex1));
		bookRepository.save(book1);

	}
}
