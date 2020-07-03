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
            "  WHERE a.name LIKE :authorName ORDER BY b.price DESC LIMIT :offset, :rowCount")
    List<Book> findBooksByAuthorName(String authorName,
                                     long offset, int rowCount);

    @Query("SELECT count(*)" +
            "  FROM book b" +
            "  JOIN author a" +
            "  ON b.author_id = a.id" +
            "  WHERE a.name LIKE :authorName")
    long countByAuthorName(String authorName);

}
