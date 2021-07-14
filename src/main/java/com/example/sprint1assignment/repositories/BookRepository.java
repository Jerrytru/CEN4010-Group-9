package com.example.sprint1assignment.repositories;

import com.example.sprint1assignment.Book;
import com.example.sprint1assignment.Wishlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BookRepository extends CrudRepository<Book,Long> {
    //List<Book> findAllByWishListName(String wish_list_name);
    List<Book> findAllByWishlist(Wishlist wishlist);
    Long deleteByName(String name);

}
