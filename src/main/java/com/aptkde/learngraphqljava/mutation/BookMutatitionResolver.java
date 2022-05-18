package com.aptkde.learngraphqljava.mutation;

import com.aptkde.learngraphqljava.model.Book;
import com.aptkde.learngraphqljava.model.BookWrapper;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class BookMutatitionResolver implements GraphQLMutationResolver {
    public Book createBook(BookWrapper bookWrapper)
    {
        return new Book(bookWrapper.getTitle(), bookWrapper.getIsbn());
    }
}
