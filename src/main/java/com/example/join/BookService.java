package com.example.join;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Join Search
     */
    public List<Book> searchBook(String authorName)
    {
        return bookRepository.findBooksByAuthorName(authorName);
    }

    public Page<Book> searchBook(String authorName, Pageable pageable)
    {
        Page<Book> bookPage = bookRepository.findAll(pageable);
        return bookPage;
    }

}
