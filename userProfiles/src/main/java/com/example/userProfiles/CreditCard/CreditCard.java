package com.example.userProfiles.CreditCard;

import com.example.userProfiles.userProfile.Profile;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
public class CreditCard {

  @Id
  @SequenceGenerator(
      name = "card_sequence",
      sequenceName = "card_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "card_sequence"
  )
  private Long cardId;
  private String provider;
  private String creditCardNum;
  private String expirationDate;
  private int CVV;


  @ManyToOne(
      cascade = CascadeType.ALL
  )
  @JoinColumn(
      name = "profile_id",
      referencedColumnName = "profileId"
  )
  private Profile profile;


  //CONSTRUCTORS
  public CreditCard() {
  }

  public CreditCard(String provider, String creditCardNum, String expirationDate, int CVV) {
    this.provider = provider;
    this.creditCardNum = creditCardNum;
    this.expirationDate = expirationDate;
    this.CVV = CVV;
  }

  public CreditCard(Long cardId, String provider, String creditCardNum,
      String expirationDate, int CVV) {
    this.cardId = cardId;
    this.provider = provider;
    this.creditCardNum = creditCardNum;
    this.expirationDate = expirationDate;
    this.CVV = CVV;
  }

  public CreditCard(String provider, String creditCardNum, String expirationDate, int CVV,
      Profile profile) {
    this.provider = provider;
    this.creditCardNum = creditCardNum;
    this.expirationDate = expirationDate;
    this.CVV = CVV;
    this.profile = profile;
  }


  @Override
  public String toString() {
    return "CreditCard{" +
        "cardId=" + cardId +
        ", provider='" + provider + '\'' +
        ", creditCardNum=" + creditCardNum +
        ", expirationDate='" + expirationDate + '\'' +
        ", CVV=" + CVV +
        '}';
  }


  //GETTERS
  public Long getCardId() {
    return cardId;
  }

  public String getProvider() {
    return provider;
  }

  public String getCreditCardNum() {
    return creditCardNum;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public int getCVV() {
    return CVV;
  }

  public Profile getProfile() {
    return profile;
  }



  //SETTERS
  public void setId(Long cardId) {
    this.cardId = cardId;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public void setCreditCardNum(String creditCardNum) {
    this.creditCardNum = creditCardNum;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public void setCVV(int CVV) {
    this.CVV = CVV;
  }

  public void assignProfile(Profile profile){
    this.profile = profile;
  }

}
