package com.polarbookshop.web_catalogue_service.repository;

import com.polarbookshop.web_catalogue_service.entity.Book;


import java.util.Optional;


public interface BookRepository {

    Iterable<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    Book save(Book book);
    void deleteByIsbn(String isbn);
}
