package com.hendisantika.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hendisantika.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

  // Query Method
  Optional<Books> findByAuthor(String author);
}
