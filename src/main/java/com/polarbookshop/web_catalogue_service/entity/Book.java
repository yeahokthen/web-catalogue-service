package com.polarbookshop.web_catalogue_service.entity;

public record Book(
        String isbn,
        String title,
        String author,
        Double price
) {
}
