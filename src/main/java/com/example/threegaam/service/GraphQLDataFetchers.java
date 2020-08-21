package com.example.threegaam.service;

import com.example.threegaam.model.Book;
import com.example.threegaam.model.User;
import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class GraphQLDataFetchers {

    private static List<Book> books = Arrays.asList(
            new Book(1L, 1L, "1391/05/12", "Java", "10235689"),
            new Book(2L, 1L, "1398/04/28", "Spring", "8965689"),
            new Book(3L, 3L, "1390/12/12", "Hibernate", "85632032"),
            new Book(4L, 5L, "1378/11/25", "GraphQL", "220300021"),
            new Book(5L, 4L, "1389/07/01", "JPA", "45700889"),
            new Book(6L, 2L, "1396/02/30", "Jira", "11250032")
    );

    private static List<User> users = Arrays.asList(
            new User(1L, "Omid Rahmani", "omid.mba@gmail.com"),
            new User(2L, "Ali Hoseinpour", "ali.hoseinpour@gmail.com"),
            new User(3L, "Mahdad Ayoubi", "mahdad@gmail.com"),
            new User(4L, "Yassin Vali", "yassin@gmail.com"),
            new User(5L, "Rahman Shamsi", "shamsi@gmail.com")
    );


    public DataFetcher getLimitBooks(){
        return dataFetchingEnvironment -> {
            int limit = dataFetchingEnvironment.getArgument("limit");
            /*System.out.println(limit);
            int limitNum = Integer.parseInt(limit);*/
            return books
                    .stream()
                    .limit(limit)
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getUsers(){
        return dataFetchingEnvironment -> users;
    }



    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            Long bookId = Long.valueOf(dataFetchingEnvironment.getArgument("id"));
            return books
                    .stream()
                    .filter(book -> book.getBookId().equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getUserDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            Long userId = book.getUserId() ;
            return users
                    .stream()
                    .filter(user -> user.getUserId().equals(userId))
                    .findFirst()
                    .orElse(null);
        };
    }


    public DataFetcher getUserById() {
        return dataFetchingEnvironment -> {
            Long userId = Long.valueOf(dataFetchingEnvironment.getArgument("id"));
            return users
                    .stream()
                    .filter(user -> user.getUserId().equals(userId))
                    .findFirst()
                    .orElse(null);
        };

    }
}
