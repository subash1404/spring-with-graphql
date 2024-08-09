package com.amigoscode;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(Integer id, String name, Integer pageCount, Integer authorId) {
    public static List<Book> books =Arrays.asList(new Book(1,"Harry",12,1),
    new Book(2,"Potter",123, 2),
    new Book(3,"fgh",13, 1),
    new Book(4,"dcfvg",5678, 2));

    public static Optional<Book> getBookById(Integer id) {
        return books.stream()
                .filter(b -> b.id.equals(id))
                .findFirst();
    }

}
