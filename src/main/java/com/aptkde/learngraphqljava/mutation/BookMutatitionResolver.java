package com.aptkde.learngraphqljava.mutation;

import com.aptkde.learngraphqljava.model.Author;
import com.aptkde.learngraphqljava.model.Book;
import com.aptkde.learngraphqljava.model.BookWrapper;
import com.aptkde.learngraphqljava.repository.AuthorRepository;
import com.aptkde.learngraphqljava.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class BookMutatitionResolver implements GraphQLMutationResolver {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookMutatitionResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(BookWrapper bookWrapper) {
        return bookRepository.save(new Book(bookWrapper.getTitle(), bookWrapper.getIsbn()));

    }

    public Book addAuthor(Long authorId, String isbn) {
        Optional<Author> author = authorRepository.findById(authorId);
        Optional<Book> book = bookRepository.findById(isbn);
        if (author.isPresent() && book.isPresent()) {
            Set<Author> authorSet=new HashSet<>();
            authorSet.add(author.get());
            book.get().setAuthors(authorSet);
            bookRepository.save(book.get());
            return book.get();
        }
        throw new GraphQLException("couldn't add author");

    }
}
