package com.example.sprint1assignment;



import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Wishlist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

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

    public Set<Book> getBooks() {
        return books;
    }

}
