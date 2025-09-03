package com.polarbookshop.web_catalogue_service.service;

import com.polarbookshop.web_catalogue_service.entity.Book;
import com.polarbookshop.web_catalogue_service.exception.BookAlreadyExistsException;
import com.polarbookshop.web_catalogue_service.exception.BookNotFoundException;
import com.polarbookshop.web_catalogue_service.repository.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBooks() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public void deleteByIsbn(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public Book addBookToCatalogue(Book book) {
        if (bookRepository.existsByIsbn(book.isbn())){
            throw new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(book);
    }


    public Book editBookDetails(String isbn, Book book) {
        return bookRepository. findByIsbn(isbn)
                .map(existingBook  -> {
                    var bookToUpdate = new Book(
                            existingBook.id(),
                            existingBook.isbn(),
                            book.title(),
                            book.author(),
                            book.price(),
                            existingBook.createdDate(),
                            existingBook.lastModifiedDate(),
                            existingBook.version()
                    );
                    return bookRepository.save(bookToUpdate);
                }).orElseGet(() -> addBookToCatalogue(book));
    }

}
