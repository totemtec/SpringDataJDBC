package com.example.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping("/book/search")
    public List<Book> searchBooks(@RequestParam String key)
    {
        return bookService.searchBook(key);
    }

    @GetMapping("/book/page")
    public Page<Book> searchBooksWithPage(@RequestParam String key,
                                          @RequestParam int page)
    {

        return bookService.searchBook(key, PageRequest.of(page, 2));
    }
}
