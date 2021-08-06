package com.mapping.service.impl;

import com.mapping.entity.Book;
import com.mapping.repository.BookRepository;
import com.mapping.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        System.out.println(book);
        Book add=Book.builder()
                .bookName(book.getBookName())
                .libraryId(book.getLibraryId())
                .author(book.getAuthor())
                .publishedBy(book.getPublishedBy())
                .build();
        return bookRepository.save(add);
    }
}

