package com.itstep.spring_demo.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private BookCategory category;

    @ManyToMany
    @JoinTable(
            name="x_book_authors",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id")
    )
    private Set<BookAuthor> authors = new HashSet<>();
}
