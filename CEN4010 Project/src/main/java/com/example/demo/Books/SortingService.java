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

  //genre
  public List<Sorting> getBookByGenre(String genre) {
    return sortingRepository.findByGenre(genre);
  }

  //top 10
  public List<Sorting> getTopTen(){
    return sortingRepository.findTop10ByOrderByCopiesSoldDesc();
  }

  //rating
  public List<Sorting> getBookByRating(double rating){
    return sortingRepository.findAllByRatingGreaterThanEqual(rating);
  }

//  //amt of books
//  public List<Books> getXBooks(int X){
//    for(int i = 0; i < X; X++){
//      return booksRepository.findOne( );
//    }
//    //return booksRepository.findAllByX(X);
//  }

}