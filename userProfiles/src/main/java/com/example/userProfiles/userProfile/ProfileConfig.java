package com.example.userProfiles.userProfile;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileConfig {

  @Bean
  CommandLineRunner commandLineRunner(ProfileRepository profileRepository) {
    return args -> {
      Profile user1 = new Profile(
          "ruria006@fiu.edu",
          "Password1",
          "Richard Uriarte",
          "ruriarte1998@gmail.com",
          "11111 SW 11ST 111111"
      );

      Profile user2 = new Profile(
          "test2",
          "test2",
          "test2 test2",
          "optionalEmail2@email.com",
          "2222 SW 22ST 222222"
      );

      //Hard coded user profiles
      profileRepository.saveAll(List.of(user1, user2));

    };

  }
}
