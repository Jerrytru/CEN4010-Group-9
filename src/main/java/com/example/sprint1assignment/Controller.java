package com.example.sprint1assignment;

import com.example.sprint1assignment.repositories.BookRepository;
import com.example.sprint1assignment.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Wishlist> newWishList(@RequestParam String name) {
            Wishlist newWishList = new Wishlist(name);
            wishlistRepository.save(newWishList);

            if (newWishList == null) {
                return ResponseEntity.notFound().build();
            }
            else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
                return ResponseEntity.created(uri).body(newWishList);
            }


    }

    @PostMapping("/wishlist/add/{name}")
    public ResponseEntity<Book> addBookToWishList(@PathVariable String name, @RequestBody Book newBook) {
        Optional<Wishlist> wishlist= wishlistRepository.findByName(name);
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
        bookRepository.deleteByName(name);

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
