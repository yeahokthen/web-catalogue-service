package com.polarbookshop.web_catalogue_service.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("A book with ISBN "+isbn+" was not found.");
    }
}
