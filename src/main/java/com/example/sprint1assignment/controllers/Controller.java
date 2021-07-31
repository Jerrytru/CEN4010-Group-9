package com.example.sprint1assignment.controllers;

import com.example.sprint1assignment.models.Book;
import com.example.sprint1assignment.models.Wishlist;
import com.example.sprint1assignment.repositories.BookRepository;
import com.example.sprint1assignment.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.net.URI;
import java.util.Optional;
import java.util.Set;


@RestController
public class Controller {

    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private BookRepository bookRepository;


    public Controller(WishlistRepository wishlistRepository, BookRepository bookRepository) {
        this.wishlistRepository = wishlistRepository;
        this.bookRepository = bookRepository;

    }

    @PostMapping("/wishlist/new/{name}")
    public ResponseEntity<String> newWishList(@RequestParam String name) {
            Wishlist newWishList = new Wishlist(name);

            wishlistRepository.save(newWishList);

            if (newWishList == null) {
                return ResponseEntity.badRequest().body(name + " not found.");
            }
            else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
                return ResponseEntity.created(uri).body("Created " + name +  " successfully.");
            }


    }

    @PostMapping("/wishlist/add/book/{wishlistName}")
    public ResponseEntity<Book> addBookToWishList(@PathVariable String wishlistName, @RequestBody Book newBook) {
        Optional<Wishlist> wishlist = wishlistRepository.findByName(wishlistName);

        if (!wishlist.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        wishlist.get().getBooks().add(newBook);
        newBook.setWishlist(wishlist.get());
        bookRepository.save(newBook);
        if (newBook == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
            return ResponseEntity.created(uri).body(newBook);
        }
    }

    @PostMapping("/wishlist/remove/{wishlistname}/book/{name}")
    public ResponseEntity<Wishlist> removeBookFromWishlist(@PathVariable String wishlistname, @PathVariable String name) {

        Optional<Wishlist> optionalWishlist = wishlistRepository.findByName(wishlistname);
        Optional<Book> optionalBook = bookRepository.findByName(name);



        if (!optionalWishlist.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        optionalWishlist.get().getBooks().remove(optionalBook.get());
        wishlistRepository.save(optionalWishlist.get());
        bookRepository.delete(optionalBook.get());



        if (!optionalWishlist.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        else {
            return ResponseEntity.ok(optionalWishlist.get());
        }
    }

    @GetMapping("/wishlist/books/{name}")
    public ResponseEntity<Wishlist> listBooksInWishList(@PathVariable String name) {
        Optional<Wishlist> optionalWishList = wishlistRepository.findByName(name);

        if (!optionalWishList.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        else {
            return ResponseEntity.ok(optionalWishList.get());
        }
    }
}
