package com.amigoscode;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @QueryMapping
    public List<Book> books(){
        return Book.books;
    }

    @QueryMapping
    public Book bookById(@Argument int id){
        return Book.books.get(id - 1);
    }

    @SchemaMapping
    public Author author(Book book){
        return Author.authors.get(book.authorId()-1);
    }
}
