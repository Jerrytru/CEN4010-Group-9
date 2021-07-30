package com.example.userProfiles.CreditCard;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

  private final CreditCardRepository creditCardRepository;

  @Autowired
  public CreditCardService(CreditCardRepository creditCardRepository) {
    this.creditCardRepository = creditCardRepository;
  }

  //Returns list of cards / GET METHOD
  public List<CreditCard> getCards(){
    return creditCardRepository.findAll();
  }


  //Saves new creditcards/ POST METHOD
  public void addNewCreditCard(CreditCard creditCard){
    creditCardRepository.save(creditCard);

    System.out.println(creditCard);
  }

}

