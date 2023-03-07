package com.itstep.spring_demo.repositories;

import com.itstep.spring_demo.models.BookCategory;
import org.springframework.data.repository.CrudRepository;

public interface BookCategoryRepository extends CrudRepository<BookCategory, Long>
{
}
