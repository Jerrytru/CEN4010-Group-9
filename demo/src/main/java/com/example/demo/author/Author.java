package com.example.demo.author;

import javax.persistence.*;

@Entity
@Table
public class Author {

    @Id
    public String firstName;
    public String lastName;
    public String biography;
    public String publisher;



    public Author(String firstName,
                  String lastName,
                  String biography,
                  String publisher)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
        this.publisher = publisher;

    }

    public Author() {
    }



    public String getfirstName(String firstName) {
        return firstName;
    }
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(String lastName) {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography(String biography) {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography= biography;
    }


    public String getPublisher(String publisher) {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}


