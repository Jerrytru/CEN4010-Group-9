package com.example.userProfiles.userProfile;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileConfig {

  @Bean
  CommandLineRunner commandLineRunner(ProfileRepository profileRepository){
    return args -> {
      Profile user1 = new Profile(
          "ruria006@fiu.edu",
          "Password1",
          "Richard Uriarte",
          "optionalEmail@email.com"
      );

      Profile user2 = new Profile(
          "test@fiu.edu",
          "test1",
          "test test",
          "optionalEmail@email.com"
      );

      //Hard coded user profiles
      profileRepository.saveAll(List.of(user1, user2));

    };

  }
}
