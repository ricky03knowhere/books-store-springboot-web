package com.hendisantika.service.framework;

import java.util.List;
import java.util.Optional;

import com.hendisantika.entity.Books;

public interface BooksService {
  List<Books> getAllBooks();

  Optional<Books> findById(Long id);

  Optional<Books> findByAuthor(String author);

  Books save(Books std);

  void deleteById(Long id);
}
