package com.example.userProfiles.CreditCard;


import com.example.userProfiles.userProfile.Profile;
import com.example.userProfiles.userProfile.ProfileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/cards")
public class CreditCardController {

  @Autowired
  ProfileRepository profileRepository;
  @Autowired
  CreditCardRepository creditCardRepository;

  private final CreditCardService creditCardService;

  @Autowired
  public CreditCardController(CreditCardService creditCardService) {
    this.creditCardService = creditCardService;
  }


  //Obtain ALL cards in repository
  @GetMapping
  public List<CreditCard> getCards() {
    return creditCardService.getCards();
  }

  //Create a new card
  @PostMapping("/registerCard")
  public void registerNewCreditCard(@RequestBody CreditCard creditCard) {
    creditCardService.addNewCreditCard(creditCard);
  }

  @PutMapping("/{cardId}/{profileId}")
  public CreditCard assignCreditCardToProfile(
      @PathVariable Long cardId,
      @PathVariable Long profileId
  ) {
    return creditCardService.assignCreditCardToProfile(cardId, profileId);
  }

}