package com.example.userProfiles.userProfile;

import com.example.userProfiles.CreditCard.CreditCard;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
  private Long profileId;
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
  public Profile(Long profileId, String userName, String password) {
    this.profileId = profileId;
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



  @JsonIgnore
  @OneToMany(
      mappedBy = "profile"
  )
  private Set<CreditCard> cards = new HashSet<>();

  @Override
  public String toString() {
    return "Profile{" +
        "id=" + profileId +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", fullName='" + fullName + '\'' +
        ", altEmail='" + altEmail + '\'' +
        '}';
  }


  //GETTERS
  public Long getProfileId() {
    return profileId;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getFullName() {
    return fullName;
  }

  public String getAltEmail() {
    return altEmail;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public Set<CreditCard> getCards() {
    return cards;
  }


  //SETTERS
  public void setProfileId(Long profileId) {
    this.profileId = profileId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setAltEmail(String altEmail) {
    this.altEmail = altEmail;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }
}
