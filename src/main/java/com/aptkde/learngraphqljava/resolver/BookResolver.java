package com.aptkde.learngraphqljava.resolver;

import com.aptkde.learngraphqljava.model.Book;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLQueryResolver {
    public Book getBook(String isbn) {
        return new Book("Learn GraphQL", "22321");
    }
}
