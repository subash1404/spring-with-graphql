package com.amigoscode;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Author(Integer id, String name) {
    public static List<Author> authors = Arrays.asList(new Author(1, "Dghj"), new Author(2, "dfghjk"));
}

