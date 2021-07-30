package com.example.userProfiles.CreditCard;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/cards")
public class CreditCardController {

  private final CreditCardService creditCardService;

  @Autowired
  public CreditCardController(CreditCardService creditCardService) {
    this.creditCardService = creditCardService;
  }


  @GetMapping
  public List<CreditCard> getCards(){
    return creditCardService.getCards();
  }


  @PostMapping
  public void registerNewCreditCard(@RequestBody CreditCard creditCard){
    creditCardService.addNewCreditCard(creditCard);
  }

}