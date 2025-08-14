package com.polarbookshop.web_catalogue_service.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book(
        @NotBlank(message = "The book ISBN must be defined.")
        @Pattern(
                regexp = "^(\\d{10}|\\d{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn,

        @NotBlank(message = "The book title must be defined.")
        String title,

        @NotBlank(message = "The book author must be defined.")
        String author,

        @NotNull
        @Positive(message = "The book price must be greater than zero.")
        Double price
) {
}
