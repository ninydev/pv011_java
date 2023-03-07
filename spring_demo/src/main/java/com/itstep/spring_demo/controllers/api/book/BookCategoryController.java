package com.itstep.spring_demo.controllers.api.book;

import com.itstep.spring_demo.models.BookAuthor;
import com.itstep.spring_demo.models.BookCategory;
import com.itstep.spring_demo.repositories.BookAuthorsRepository;
import com.itstep.spring_demo.repositories.BookCategoryRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book/category")
public class BookCategoryController {

    final
    BookCategoryRepository bookCategoryRepository;


    public BookCategoryController(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @GetMapping("/")
    public Iterable<BookCategory> index(){
        return bookCategoryRepository.findAll();
    }

    @PostMapping("/")
    public BookCategory create(@RequestBody BookCategory category)  {
        return bookCategoryRepository.save(category);
    }
}
