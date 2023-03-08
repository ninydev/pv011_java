package com.itstep.spring_demo.repositories;

import com.itstep.spring_demo.models.Book;
import com.itstep.spring_demo.models.BookCategory;
import com.itstep.spring_demo.presenters.BookSmallPresenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>
// public interface BookRepository extends PagingAndSortingRepository<Book, Long>
{

    // Если нет возможности сменить тип репозитория - описываем запрос
    // @Query
    // Iterable<Book> findAllByPage(long perPage, long page);

    // Четкое равенство
    Book findByName(String name);

    // LIKE %name%
    Book findByNameContains(String name);

    // LIKE name%
    Book findByNameStartsWith(String name);

   // свой вариант запроса
    @Query("SELECT b FROM Book b  WHERE b.name LIKE %:name%")
    Book searchBookByQuery(String name);

    @Query("SELECT a.books  FROM BookAuthor a WHERE a.id = :author_id")
    Iterable<Book> findBookByAuthorId(long author_id);

    @Query("SELECT b.name AS name, b.id AS num FROM Book b  WHERE b.id = :id")
    Object findObjectById(long id);

//    @Query("SELECT b.name AS name, b.id AS num FROM Book b  WHERE b.id = :id")
//    BookSmallPresenter findObjectById(long id);


    //@Query("SELECT a.books FROM BookAuthor a WHERE a.id = :author_id")
    //Iterable<Book> findBookByAuthorId(long author_id);
}
