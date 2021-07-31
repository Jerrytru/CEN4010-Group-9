package com.example.demo.author;


import com.example.demo.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {
    private AuthorService authorService;
    private BookService bookService;


    @Autowired
    public AuthorController(AuthorService bookService, AuthorService authorService) {

        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping
    public void registerNewAuthor(@RequestBody Author author) {
        authorService.addNewAuthor(author);
    }
}





