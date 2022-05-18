package com.aptkde.learngraphqljava.resolver;

import com.aptkde.learngraphqljava.model.Book;
import com.aptkde.learngraphqljava.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLQueryResolver {

    private final BookRepository bookRepository;
    @Autowired
    public BookResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(String isbn) {
        Book book=bookRepository.findById(isbn).orElse(new Book("Заглушка","000"));
        return book;
    }
}
