package com.hendisantika.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hendisantika.entity.Books;
import com.hendisantika.exception.BooksNotFoundException;
import com.hendisantika.service.framework.BooksService;

@RestController
@RequestMapping("/api/books")
public class BooksController {
  private final BooksService booksService;

  @Autowired
  public BooksController(BooksService booksService) {
    this.booksService = booksService;
  }

  @GetMapping
  public List<Books> getAllBooks() {
    return booksService.getAllBooks();
  }

  @GetMapping(value = "/{id}")
  public Books getBooksById(@PathVariable("id") @Min(1) Long id) {
    Books std = booksService.findById(id)
        .orElseThrow(() -> new BooksNotFoundException("Books with " + id + " is not found!"));

    return std;
  }

  @PostMapping
  public Books addBooks(@Valid @RequestBody Books std) {
    return booksService.save(std);
  }

  @PutMapping(value = "/{id}")
  public Books updateBooks(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Books newStd) {

    Books student = booksService.findById(id)
        .orElseThrow(() -> new BooksNotFoundException("Books with " + id + " is not found!"));

    student.setTitle(newStd.getTitle());
    student.setAuthor(newStd.getAuthor());
    student.setDescription(newStd.getDescription());
    student.setPrice(newStd.getPrice());
    student.setStock(newStd.getStock());

    return booksService.save(student);
  }

  @DeleteMapping(value = "/{id}")

  public String deleteBooks(@PathVariable("id") @Min(1) Long id) {
    Books std = booksService.findById(id)
        .orElseThrow(() -> new BooksNotFoundException("Books with " + id + " is not found!"));
    booksService.deleteById(std.getId());

    return "Books with ID " + id + " is deleted";
  }
}
