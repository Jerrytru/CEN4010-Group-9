package com.example.sprint1assignment.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ISBN;
    private String name;
    private String description;
    private String author;
    private String yearPublished;
    private String publisher;
    private String genre;
    private int price;
    private int copiesSold;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "wishlists_name")
    @JsonIgnore
    private Wishlist wishlist;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shoppingcarts_name")
    @JsonIgnore
    private Shoppingcart shoppingcart;


    public Book() {}

    public Book(String name) {
        this.name = name;
    }


    public Book(String ISBN, String name, String description, String author, String yearPublished, String publisher, String genre, int price, int copiesSold) {
        this.ISBN = ISBN;
        this.name = name;
        this.description = description;
        this.author = author;
        this.yearPublished = yearPublished;
        this.publisher = publisher;
        this.genre = genre;
        this.price = price;
        this.copiesSold = copiesSold;
    }

    public String getDescription() {
        return description;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }
}
