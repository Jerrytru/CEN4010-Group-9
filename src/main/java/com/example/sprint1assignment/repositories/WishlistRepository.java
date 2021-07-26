package com.example.sprint1assignment.repositories;

import com.example.sprint1assignment.models.Book;
import com.example.sprint1assignment.models.User;
import com.example.sprint1assignment.models.Wishlist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends CrudRepository<Wishlist, Long> {
    Optional<Wishlist> findByName(String name);
    List<Wishlist> findAllByName(String name);
    Wishlist deleteByBooks(Book book);
    //List<Wishlist> countWishlistsByUser(User user);
    Wishlist deleteByBooksIs(Book book);


}

