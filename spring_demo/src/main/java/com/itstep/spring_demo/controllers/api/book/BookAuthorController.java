package com.itstep.spring_demo.controllers.api.book;

import com.itstep.spring_demo.models.BookAuthor;
import com.itstep.spring_demo.repositories.BookAuthorsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book/author")
public class BookAuthorController {

    final
    BookAuthorsRepository authorsRepository;


    public BookAuthorController(BookAuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @GetMapping("/")
    public Iterable<BookAuthor> index(){
        return authorsRepository.findAll();
    }

    @PostMapping("/")
    public BookAuthor create(BookAuthor author)  {
        return authorsRepository.save(author);
    }
}
