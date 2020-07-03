package com.example.join;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
    public Page<Book> searchBook(String authorName, Pageable pageable)
    {
        List<Book> bookList = bookRepository.findBooksByAuthorName("%"+authorName+"%",
                pageable.getOffset(), pageable.getPageSize()
        );
        long count = bookRepository.countByAuthorName("%"+authorName+"%");
        Page<Book> page = new PageImpl(bookList, pageable, count);
        return page;
    }

}
