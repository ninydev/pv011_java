package com.itstep.spring_demo.repositories;

import com.itstep.spring_demo.models.Book;
import com.itstep.spring_demo.models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>
{
}
