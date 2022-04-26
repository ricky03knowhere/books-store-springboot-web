package com.hendisantika.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hendisantika.entity.Books;
import com.hendisantika.service.framework.BooksService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BooksWebController {
  private BooksService booksService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("books", booksService.getAllBooks());
    return "index";
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("books", new Books());
    return "formBooks";
  }

  @PostMapping("/create")
  public String addBooks(Model model, Books books) {
    model.addAttribute("books", booksService.save(books));
    return "redirect:/";
  }

  @GetMapping("/detail/{id}")
  public String detail(@PathVariable Long id, Model model) {
    booksService.findById(id).ifPresent(book -> model.addAttribute("book", book));
    return "detailBook";
  }

  @GetMapping("/edit/{id}")
  public String index(@PathVariable Long id, Model model) {
    model.addAttribute("books", booksService.findById(id));
    return "formBooks";
  }

  @GetMapping("/delete/{id}")
  public String index(@PathVariable Long id) {
    booksService.deleteById(id);
    return "redirect:/";
  }
}
