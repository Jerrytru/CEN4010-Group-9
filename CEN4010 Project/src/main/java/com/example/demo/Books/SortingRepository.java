package com.example.demo.Books;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //data access
public interface SortingRepository extends JpaRepository<Sorting,Integer> {


  //Retrieve List of books by Genre
  List<Sorting> findByGenre(String genre);

  //Retrieve List of top 10 books in Descending order.
  List<Sorting> findTop10ByOrderByCopiesSoldDesc();

  //  Retrieve List of books for a particular rating or higher
  List<Sorting> findAllByRatingGreaterThanEqual(double rating);

  //Retrieve List of X Books at a time where X is an integer
//  List<Books> findAllByX(int X);
}
