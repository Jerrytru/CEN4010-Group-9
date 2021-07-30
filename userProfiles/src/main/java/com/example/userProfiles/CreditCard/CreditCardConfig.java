package com.example.userProfiles.CreditCard;

import com.example.userProfiles.userProfile.Profile;
import com.example.userProfiles.userProfile.ProfileRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
public class CreditCardConfig {

  Profile profile;
  ProfileRepository profileRepository;

  @Bean
  CommandLineRunner commandLineRunner2(CreditCardRepository creditCardRepository){
    return args -> {
      CreditCard card1 = new CreditCard(
          "VISA",
          "4916471220673253",
          "8/2025",
          156
          //profileRepository.findProfileByUserName("test1")  //The profile/user I am trying to attach this credit card to
      );

      CreditCard card2 = new CreditCard(
          "VISA",
          "4716881154127849",
          "12/2025",
          654
      );

      creditCardRepository.saveAll(List.of(card1, card2));
    };
  }

}
