package com.itstep.spring_demo.controllers.api.book;

import com.itstep.spring_demo.models.Book;
import com.itstep.spring_demo.models.BookCategory;
import com.itstep.spring_demo.repositories.BookCategoryRepository;
import com.itstep.spring_demo.repositories.BookRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController
{
    // @Autowired
    final BookRepository bookRepository;
    final BookCategoryRepository bookCategoryRepository;

    public BookController(
            BookCategoryRepository bookCategoryRepository,
            BookRepository bookRepository
    ) {
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
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
    public Book findById(@PathVariable long id){
        return bookRepository.findById(id).get();
    }

    @GetMapping("/name/{name}")
    public Book findById(@PathVariable String name){
        return bookRepository.findByName(name);
    }

    /**
     * Create
     *
     * @param book new Book
     * @return
     */
    @PostMapping("/")
    public ResponseEntity create(
            @RequestBody Book book
    ) {
        BookCategory category =bookCategoryRepository.findById(book.getCategory_id()).get();
        System.out.println("+-------------------+");
        System.out.println(category);

        book.setCategory(category);

        //book.setCategory();
        System.out.println("+-------------------+");
        System.out.println(book);

        try {
            bookRepository.save(book);
            return ResponseEntity
                    .status(201)
                    .body(bookRepository.save(book));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity
                    .status(422)
                    .body(exception.getMessage());
        }
    }

    /**
     * Create
     *
     * @param book new Book
     * @return
     */
    @PostMapping("/createFullObj")
    public ResponseEntity createFullObj(@RequestBody Book book) {
        System.out.println("+-------------------+");
        System.out.println(book);
        try {
            bookRepository.save(book);
            return ResponseEntity
                    .status(201)
                    .body(bookRepository.save(book));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity
                    .status(422)
                    .body(exception.getMessage());
        }
    }



    public void createMany(List<Book> books) {
        bookRepository.saveAll(books);
    }




}
