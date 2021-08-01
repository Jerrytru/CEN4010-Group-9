package com.example.demo.Books;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/books")
public class SortingController {

  private final SortingService sortingService;

  @Autowired
  public SortingController(SortingService sortingService) {
    this.sortingService = sortingService;
  }

  @GetMapping("/genre/{genre}")
  public List<Sorting> getGenre(@PathVariable String genre) {
    return sortingService.getBookByGenre(genre);
  }

  @GetMapping("/top10")
  public List<Sorting> getTop(){
    return sortingService.getTopTen();
  }

  @GetMapping("/rating/{rating}")
  public List<Sorting> getRating(@PathVariable double rating){
    return sortingService.getBookByRating(rating);
  }

  @GetMapping("/index/{index}")
  public List<Sorting> getBooks(@PathVariable int index){
    return sortingService.getBookByX(index);
  }

  @PostMapping
  public void registerNewBook(@RequestBody Sorting sorting){
    sortingService.addNewBook(sorting);
  }

}
