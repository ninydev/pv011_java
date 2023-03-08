package com.itstep.spring_demo.controllers.api.book;

import com.itstep.spring_demo.models.Book;
import com.itstep.spring_demo.models.BookCategory;
import com.itstep.spring_demo.presenters.BookSmallPresenter;
import com.itstep.spring_demo.repositories.BookCategoryRepository;
import com.itstep.spring_demo.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Book findByName(@PathVariable String name){
        // return bookRepository.findByName(name);
        bookRepository.findByNameContains(name);
        return bookRepository.searchBookByQuery(name);
    }

    @GetMapping("/author/{author_id}")
    public Iterable<Book>  findBookByAuthorId(@PathVariable long author_id){
        return bookRepository.findBookByAuthorId(author_id);
    }

    @GetMapping("/object/{id}")
    public Object findObjectById(@PathVariable long id){
        return bookRepository.findObjectById(id);
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
