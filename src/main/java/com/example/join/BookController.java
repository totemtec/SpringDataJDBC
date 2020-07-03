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


    @GetMapping("/book/list")
    public Page<Book> searchBooksWithPage(@RequestParam String key,
                                          @RequestParam int page,
                                          @RequestParam(defaultValue = "2") int size)
    {

        return bookService.searchBook(key, PageRequest.of(page, size));
    }
}
