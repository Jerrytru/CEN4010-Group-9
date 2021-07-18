package com.example.sprint1assignment.models;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String author;
    private String date;
    private String genre;
    private int copiesSold;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlists_name")
    private Wishlist wishlist;


    public Book() {}

    public Book(String name) {
        this.name = name;
    }
    public Book(String name, String author, String date, String genre, int copiesSold) {
        this.name = name;
        this.author = author;
        this.date = date;
        this.genre = genre;
        this.copiesSold = copiesSold;
    }

    public String getDescription() {
        return description;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public void setWishListName(String wishListName) {
        wishlist.setName(wishListName);
    }
}
