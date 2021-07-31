package com.example.demo.book;

import javax.persistence.*;

@Entity
@Table
public class Book {

    @Id
    private int ISBN;
    private String bookName;
    private String bookDescription;
    private double price;
    private String author;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;
    private double ratings;

    public Book() {
    }

    public Book(int ISBN, String bookName, String bookDescription, double price, String author, String genre, String publisher, int yearPublished, int copiesSold, double ratings) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.ratings = ratings;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public double getPrice() {
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

    public int getYearPublished() {
        return yearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public double getRatings() {
        return ratings;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public void setPrice(double price) {
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

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearPublished=" + yearPublished +
                ", copiesSold=" + copiesSold +
                ", ratings=" + ratings +
                '}';
    }
}
