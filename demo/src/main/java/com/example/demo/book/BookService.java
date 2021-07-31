package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookJSON(){
        return  bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        System.out.println(book);
        bookRepository.save(book);
    }

    public Book getByISBN(int isbn) {
        return bookRepository.getByISBN(isbn);
    }


    public List<Book> getByAuthor(String author) {
        return bookRepository.getByAuthor(author);
    }
}
