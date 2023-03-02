package com.itstep.spring_demo.controllers.api;

import com.itstep.spring_demo.models.Book;
import com.itstep.spring_demo.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController
{
    // @Autowired
    final BookRepository bookRepository;

    private int access_level; // 0 // (1)


    public BookController(BookRepository bookRepository) {
        System.out.println("\n\nController is created\n\n");
        this.bookRepository = bookRepository;
    }


    /**
     * Получить коллекцию книг
     * @return Iterable<Book>
     */
    @GetMapping("/")
    public Iterable<Book> index(){
        return bookRepository.findAll();
    }

    /**
     * Получить книгу по id
     * @param id long
     * @return Book
     */
    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable long id){
        return bookRepository.findById(id);
    }

    /**
     * Create
     * @param book new Book
     */
    @PostMapping("/")
    public void create(Book book) {
        bookRepository.save(book);
    }




}
