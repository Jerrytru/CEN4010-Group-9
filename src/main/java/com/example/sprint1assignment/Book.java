package com.example.sprint1assignment;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String author;
    private String date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlists_name")
    private Wishlist wishlist;


    public Book() {}

    public Book(String name) {
        this.name = name;
    }
    public Book(String name, String author, String date) {
        this.name = name;
        this.author = author;
        this.date = date;
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
