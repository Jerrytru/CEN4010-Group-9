package com.example.sprint1assignment.models;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
public class Wishlist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "wishlist",cascade = CascadeType.REMOVE)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Book> books = new ArrayList<>();

    /*@ManyToOne
    @JoinColumn(name = "user")
    private User user;*/

    public Wishlist() { }


    public Wishlist(String name) {
        this.name = name;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wishlist wishlist = (Wishlist) o;
        return id == wishlist.id && name.equals(wishlist.name) && Objects.equals(books, wishlist.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, books);
    }

    public List<Book> getBooks() {
        return books;
    }


}
