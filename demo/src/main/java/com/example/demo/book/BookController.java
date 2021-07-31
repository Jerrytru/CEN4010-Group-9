package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBookJSON();
    }

    @PostMapping
    public void registerNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @GetMapping("/ISBN/{ISBN}")
    public Book getDetail(@PathVariable int ISBN){
         return bookService.getByISBN(ISBN);
    }

    @GetMapping("/search/{author}/")
    public List<Book> getByName(@PathVariable String author){
        String newString = author.replace("+", " ");
        return bookService.getByAuthor(newString);

    }
}
