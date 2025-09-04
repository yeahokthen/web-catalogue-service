package com.polarbookshop.web_catalogue_service;

import com.polarbookshop.web_catalogue_service.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class BookJsonTest {

    @Autowired
    private JacksonTester<Book> json;

    @Test
    void testSerialize() throws Exception {
        var book = Book.of("1234567890", "Title", "Author",9.90, "publisher");
        var jsonContent = json.write(book);

        assertThat(jsonContent).hasJsonPathStringValue("@.isbn");
        assertThat(jsonContent).extractingJsonPathStringValue("@.isbn").isEqualTo(book.isbn());

        assertThat(jsonContent).hasJsonPathStringValue("@.title");
        assertThat(jsonContent).extractingJsonPathStringValue("@.title").isEqualTo(book.title());

        assertThat(jsonContent).hasJsonPathStringValue("@.author");
        assertThat(jsonContent).extractingJsonPathStringValue("@.author").isEqualTo(book.author());

        assertThat(jsonContent).extractingJsonPathNumberValue("@.price").isEqualTo(book.price());
        assertThat(jsonContent).extractingJsonPathStringValue("@.publisher").isEqualTo(book.publisher());

    }

    @Test
    void testDeserialize() throws Exception {
        var content = """
                {
                "isbn": "1234567890",
                "title": "Title",
                "author": "Author",
                "price": 9.90,
                "publisher": "Publisher"
                }
                """;

        assertThat(json.parse(content)).usingRecursiveComparison().isEqualTo(Book.of("1234567890", "Title", "Author", 9.90,  "publisher"));

    }


}
