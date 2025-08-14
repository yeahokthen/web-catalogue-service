package com.polarbookshop.web_catalogue_service.controller;
import com.polarbookshop.web_catalogue_service.exception.BookNotFoundException;
import com.polarbookshop.web_catalogue_service.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private BookController bookController;

    @MockitoBean
    private BookService bookService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenBookNotExistingThenReturn404() throws Exception {
        String isbn = "73737313940";
        given(bookService.viewBookDetails(isbn)).willThrow(BookNotFoundException.class);
        mockMvc.perform(get("/books/"+isbn))
                .andExpect(status().isNotFound());

    }
}