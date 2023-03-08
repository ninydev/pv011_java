package com.itstep.spring_demo.controllers.api.book;

import com.itstep.spring_demo.models.Book;
import com.itstep.spring_demo.models.BookAuthor;
import com.itstep.spring_demo.repositories.BookAuthorsRepository;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/search/{author_id}")
//    public Iterable<Book> searchBooksByAuthorsId(@PathVariable long author_id ) {
//        //BookAuthor a = authorsRepository.findById(author_id).get();
//        //BookAuthor a = authorsRepository.find;
//        //Iterable<Book> lst = a.getBooks();
//        //return  lst;
//    }
}
