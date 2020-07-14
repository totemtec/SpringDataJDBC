package com.example.sum;

import com.example.join.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StepRepository extends PagingAndSortingRepository<Book, Long> {

    @Query("select count(*) from " +
            "(SELECT DISTINCT user_id FROM step WHERE `timestamp`>:startTime AND `timestamp`<:endTime GROUP BY user_id) as t")
    long countDomateUser(long startTime, long endTime);

    @Query("SELECT count(*) from step WHERE `timestamp`>:startTime AND `timestamp`<:endTime")
    long countDomateTimes(long startTime, long endTime);

    @Query("SELECT sum(step) from step WHERE `timestamp`>:startTime AND `timestamp`<:endTime")
    long countDomateSteps(long startTime, long endTime);

    @Query("SELECT count(*) from user WHERE `create_time`>:startTime AND `create_time`<:endTime")
    long countUsers(long startTime, long endTime);

}
