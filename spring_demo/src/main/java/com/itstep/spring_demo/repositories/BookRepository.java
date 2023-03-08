package com.itstep.spring_demo.repositories;

import com.itstep.spring_demo.models.Book;
import com.itstep.spring_demo.models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>
{

    // Четкое равенство
    Book findByName(String name);

    // LIKE %name%
    Book findByNameContains(String name);

    // LIKE name%
    Book findByNameStartsWith(String name);

   // свой вариант запроса
    @Query("SELECT b FROM Book b  WHERE b.name LIKE %:name%")
    Book searchBookByQuery(String name);


}
