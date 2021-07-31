package com.example.demo.author;

import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    @Autowired
    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> getAuthors(){
        return  authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        System.out.println(author);
        authorRepository.save(author);
    }

    public List<Book> getByFirstName(String author) {
        return bookRepository.getByAuthor(author);
    }
}






