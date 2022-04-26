package com.hendisantika.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hendisantika.entity.Books;
import com.hendisantika.repository.BooksRepository;
import com.hendisantika.service.framework.BooksService;

@Service
public class BooksServiceImpl implements BooksService {
  private final BooksRepository booksRepository;

  @Autowired
  public BooksServiceImpl(BooksRepository booksRepository) {
    this.booksRepository = booksRepository;
  }

  @Override
  public List<Books> getAllBooks() {
    return booksRepository.findAll();
  }

  @Override
  public Optional<Books> findById(Long id) {
    return booksRepository.findById(id);
  }

  @Override
  public Optional<Books> findByAuthor(String author) {
    return booksRepository.findByAuthor(author);
  }

  @Override
  public Books save(Books std) {
    return booksRepository.save(std);
  }

  @Override
  public void deleteById(Long id) {
    booksRepository.deleteById(id);
  }

}
