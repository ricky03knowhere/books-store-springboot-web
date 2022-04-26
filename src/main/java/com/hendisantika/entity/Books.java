package com.hendisantika.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Books {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty(message = "Title is required")
  @Column(nullable = false, name = "title")
  private String title;

  @NotEmpty(message = "Author is required")
  @Column(nullable = false, name = "author")
  private String author;

  @NotEmpty(message = "Description name is required")
  @Column(nullable = false, name = "description")
  private String description;

  @NotNull(message = "Price Number is required")
  @Column(nullable = false, name = "price")
  private int price;

  @NotNull(message = "Stock is required")
  @Column(nullable = false, name = "stock")
  private int stock;
}
