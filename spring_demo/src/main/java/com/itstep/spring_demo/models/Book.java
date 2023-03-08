package com.itstep.spring_demo.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.jackson.JsonComponent;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Transient // Временное свойтсво - для VM (для получения данных с формы
    private Long category_id;

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
