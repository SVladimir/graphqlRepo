package com.aptkde.learngraphqljava.mutation;

import com.aptkde.learngraphqljava.model.Author;
import com.aptkde.learngraphqljava.model.AuthorWrapper;
import com.aptkde.learngraphqljava.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {


    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorMutationResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(AuthorWrapper wrapper) {
        Author author=new Author(wrapper.getName());
        //author.setId(UUID.randomUUID().toString());
        return authorRepository.save(author);
    }

}
