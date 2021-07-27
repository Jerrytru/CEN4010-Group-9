package com.example.sprint1assignment.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Shoppingcart {
    @Id
    private long id;
    private String name;



   /* @OneToOne
    User user;*/

    @OneToMany(mappedBy = "shoppingcart", cascade = CascadeType.REMOVE)
    private Set<Book> books = new HashSet<>();


    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
