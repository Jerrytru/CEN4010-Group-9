package com.example.demo.Books;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Sorting {

  @Id
  @SequenceGenerator(
      name = "book_sequence",
      sequenceName = "book_sequence",
      allocationSize = 1
  )

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "student_sequence"
  )

  private int ISBN;
  private String book;
  private String description;
  private int price;
  private String author;
  private String genre;
  private String publisher;
  private int year;
  private int copiesSold;
  private double rating;

  public Sorting() {

  }

  //constuctor
  public Sorting(int ISBN, String book, String description, int price, String author,
      String genre, String publisher, int year, int copiesSold, double rating) {
    this.ISBN = ISBN;
    this.book = book;
    this.description = description;
    this.price = price;
    this.author = author;
    this.genre = genre;
    this.publisher = publisher;
    this.year = year;
    this.copiesSold = copiesSold;
    this.rating = rating;
  }

  //getters
  public int getISBN() {
    return ISBN;
  }

  public String getBook() {
    return book;
  }

  public String getDescription() {
    return description;
  }

  public int getPrice() {
    return price;
  }

  public String getAuthor() {
    return author;
  }

  public String getGenre() {
    return genre;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getYear() {
    return year;
  }

  public int getCopiesSold() {
    return copiesSold;
  }

  public double getRating(){return rating;}


  //setters
  public void setISBN(int ISBN) {
    this.ISBN = ISBN;
  }

  public void setBook(String book) {
    this.book = book;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setCopiesSold(int copiesSold) {
    this.copiesSold = copiesSold;
  }

  public void setRating(double rating){
    this.rating = rating;
  }


  @Override
  public String toString() {
    return "Books{" +
        "ISBN=" + ISBN +
        ", book='" + book + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", author='" + author + '\'' +
        ", genre='" + genre + '\'' +
        ", publisher='" + publisher + '\'' +
        ", year=" + year +
        ", copiesSold=" + copiesSold +
        ", rating=" + rating +
        '}';
  }
}
