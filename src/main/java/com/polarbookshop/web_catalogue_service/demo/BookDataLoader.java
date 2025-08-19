package com.polarbookshop.web_catalogue_service.demo;

import com.polarbookshop.web_catalogue_service.entity.Book;
import com.polarbookshop.web_catalogue_service.repository.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testData")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 =  new Book("1234567891", "Northern Lights", "Lyra Silverstar", 9.90);
        bookRepository.save(book1);
        var book2 =  new Book("1234567892", "Polar Journey", "Iorek Polarson", 12.90);
        bookRepository.save(book2);
    }

}
