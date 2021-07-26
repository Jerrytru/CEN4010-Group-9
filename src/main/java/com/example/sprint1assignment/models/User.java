package com.example.sprint1assignment.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    @Basic(optional = true)
    private String name;
    @Basic(optional = true)
    private String email;
    @Basic(optional = true)
    private String homeAddress;
    /*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Wishlist> wishlist;*/
    @OneToOne
    Shoppingcart shoppingcart;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String name, String email, String homeAddress) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public Set<Wishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(Set<Wishlist> wishlist) {
        this.wishlist = wishlist;
    }*/

    public Shoppingcart getShoppingcart() {
        return shoppingcart;
    }

    public void setShoppingcart(Shoppingcart shoppingcart) {
        this.shoppingcart = shoppingcart;
    }
}
