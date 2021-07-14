package com.example.sprint1assignment.repositories;

import com.example.sprint1assignment.Book;
import com.example.sprint1assignment.Wishlist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends CrudRepository<Wishlist, Long> {
    Optional<Wishlist> findByName(String name);
    List<Wishlist> findAllByName(String name);
    Wishlist deleteByBooks(Book book);


}
