package com.example.demo.Books;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SortingService {

  private final SortingRepository sortingRepository;

  @Autowired
  public SortingService(SortingRepository sortingRepository) {
    this.sortingRepository = sortingRepository;
  }

  public List<Sorting> getBooks() {
    return sortingRepository.findAll();
  }

  //POST method to add to the database
  public void addNewBook(Sorting sorting) {
    System.out.println(sorting);
    sortingRepository.save(sorting);
  }

  // Retrieve List of Books by Genre
  public List<Sorting> getBookByGenre(String genre) {
    return sortingRepository.findByGenre(genre);
  }

  // Retrieve List of Top Sellers (Top 10 books that have sold the most copies
  public List<Sorting> getTopTen(){
    return sortingRepository.findTop10ByOrderByCopiesSoldDesc();
  }

  // Retrieve List of Books for a particular rating and higher
  public List<Sorting> getBookByRating(double rating){
    return sortingRepository.findAllByRatingGreaterThanEqual(rating);
  }

  // Retrieve List of X Books at a time where X is an int
  public List<Sorting> getBookByX(int index){
    List<Sorting> books = new ArrayList<>();
    for(int i = 0; i < index; i++){
      books.add(sortingRepository.findAll().get(i));
    }
    return books;
  }

}
