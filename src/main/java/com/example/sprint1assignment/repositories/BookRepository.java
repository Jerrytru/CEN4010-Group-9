package com.example.sprint1assignment.repositories;

import com.example.sprint1assignment.models.Book;
import com.example.sprint1assignment.models.Wishlist;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BookRepository extends CrudRepository<Book,Long> {
    //List<Book> findAllByWishListName(String wish_list_name);
    List<Book> findAllByWishlist(Wishlist wishlist);
    Long deleteByName(String name);

}
