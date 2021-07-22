package com.example.userProfiles.userProfile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity   //For Hibernate
@Table    //For table in database
public class Profile {
  @Id
  @SequenceGenerator(
      name = "profile_sequence",
      sequenceName = "profile_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "profile_sequence"
  )
  private Long id;
  private String userName;    //email
  private String password;
  private String fullName;
  private String altEmail;
  private String homeAddress;

  //CONSTRUCTORS
  public Profile() {
  }

  //Constructor without Id
  public Profile(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  //Constructor With Id
  public Profile(Long id, String userName, String password) {
    this.id = id;
    this.userName = userName;
    this.password = password;
  }
  public Profile(String userName, String password, String fullName, String altEmail) {
    this.userName = userName;
    this.password = password;
    this.fullName = fullName;
    this.altEmail = altEmail;
  }

  public Profile(String userName, String password, String fullName, String altEmail,
      String homeAddress) {
    this.userName = userName;
    this.password = password;
    this.fullName = fullName;
    this.altEmail = altEmail;
    this.homeAddress = homeAddress;
  }

  @Override
  public String toString() {
    return "Profile{" +
        "id=" + id +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", fullName='" + fullName + '\'' +
        ", altEmail='" + altEmail + '\'' +
        '}';
  }


  //GETTERS
  public Long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }


  //SETTERS
  public void setId(Long id) {
    this.id = id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
