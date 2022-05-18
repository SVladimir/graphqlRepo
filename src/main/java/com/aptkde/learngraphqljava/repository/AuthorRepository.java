package com.aptkde.learngraphqljava.repository;

import com.aptkde.learngraphqljava.model.Author;
import com.aptkde.learngraphqljava.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,String> {

}
