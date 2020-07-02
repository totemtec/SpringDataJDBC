package com.example.join;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    @Query("SELECT b.id id, b.title title, a.name author_name" +
            "  FROM book b" +
            "  JOIN author a" +
            "  ON b.author_id = a.id" +
            "  WHERE a.name LIKE :authorName")
    List<Book> findBooksByAuthorName(String authorName);


    @Query(value = "SELECT b.id id, b.title title, a.name author_name" +
            "  FROM book b" +
            "  JOIN author a" +
            "  ON b.author_id = a.id" +
            "  WHERE a.name LIKE ?1 ORDER BY ?#{#pageable}")
    Page<Book> findBooksByAuthorName(String authorName, Pageable pageable);

}
