package com.example.demo.author;

import com.example.demo.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository <Author, Integer> {

    Book getByFirstName(String firstName);
}
