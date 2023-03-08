package com.itstep.spring_demo.repositories;

import com.itstep.spring_demo.models.BookAuthor;
import org.springframework.data.repository.CrudRepository;

public interface BookAuthorsRepository  extends CrudRepository<BookAuthor, Long>
{


}
