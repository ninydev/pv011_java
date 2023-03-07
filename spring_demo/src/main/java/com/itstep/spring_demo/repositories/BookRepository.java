package com.itstep.spring_demo.repositories;

import com.itstep.spring_demo.models.Book;
import com.itstep.spring_demo.models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>
{
    List<Book> findByCategory(BookCategory category);

    Book findByName(String name);

}
