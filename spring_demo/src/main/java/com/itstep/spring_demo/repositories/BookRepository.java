package com.itstep.spring_demo.repositories;

import com.itstep.spring_demo.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{
}
