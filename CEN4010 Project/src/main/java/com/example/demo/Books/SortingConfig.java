package com.example.demo.Books;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SortingConfig {

  @Bean
  CommandLineRunner commandLineRunner(SortingRepository repository){
    return args -> {
      Sorting ChainsawMan = new Sorting(
          32121,
          "Chainsaw",
          "Broke young man + chainsaw dog demon = Chainsaw Man!",
          10,
          "Tatsuki Fujimoto",
          "Horror",
          "VIZ Media",
          2019,
          11000000,
          4.2
      );

      Sorting Twilight = new Sorting(
          198032,
          "Twilight",
          "Vampire and Human fall in love.",
          27,
          "Stephenie Meyer",
          "Romance",
          "Little, Brown and Company",
          2005,
          100000000,
          3.2
      );

      Sorting Notebook = new Sorting(
          438920,
          "Notebook",
          "Love story between two teens in hospital.",
          20,
          "someone",
          "Romance",
          "idk man",
          2005,
          30000000,
          4.3
      );

      Sorting BillySummers = new Sorting(
          927420,
          "Billy Summers",
          "Billy Summers is a man in a room with a gun. He’s a killer for \n"
              + "hire and the best in the business. ",
          15,
          "Stephan King",
          "Crime",
          "Charles Scribner's Sons",
          2021,
          4000000,
          4.8
      );

      Sorting AmericanMarxism = new Sorting(
          567893,
          "American Marxism",
          "In American Marxism, Levin explains how the core elements of \n"
              + "Marxist ideology are now pervasive in American society...",
          20,
          "Mark Levin",
          "Educational",
          "Threshold Edition",
          2021,
          893000,
          4.9
      );

      Sorting Together = new Sorting(
          67583,
          "Together",
          "A gentle and philosophical look at the events of 2020, and how\n "
              + "we can deal with the challenges that life throws us in general.",
          16,
          "Luke Adam Hawker",
          "Philosophy",
          "Octopus Books",
          2021,
          2000000,
          3.9
      );

      Sorting ThePassengers = new Sorting(
          12039,
          "The Passengers",
          "You’re riding in your self-driving car when suddenly the doors\n"
              + " lock, the route changes and you have lost all control.",
          15,
          "John Marrs",
          "Sci-Fi",
          "Penguin Publishing Books",
          2019,
          13000000,
          4.1
      );

      Sorting IT = new Sorting(
          48022,
          "IT",
          "The story follows the experiences of seven children as they are\n"
              + " terrorized by an evil entity.",
          18,
          "Stephan King",
          "Horror",
          "Viking Press",
          1986,
          589000000,
          5
      );

      Sorting MidnightSun = new Sorting(
          48729,
          "Midnight Sun",
          " The work retells the events of Twilight from the perspective \n"
              + "of Edward Cullen instead of that of the series' usual narrating\n"
              + " character Bella Swan.",
          27,
          "Stephanie Meyer",
          "Romance",
          "Little, Brown and Company",
          2020,
          4000000,
          3.7
      );

      Sorting ShadowAndBone = new Sorting(
          53829,
          "Shadow and Bone",
          "Alina unleashes dormant magic not even she knew she possessed.",
          10,
          "Leigh Bardugo",
          "Fantasy",
          "Macmillan Publishers",
          2012,
          3002000,
          4.6
      );

      Sorting GhostShadow = new Sorting(
          53829,
          "Ghost Shadow",
          "There are those who walk among us who are no longer alive, but\n "
              + "not yet crossed over. They seek retribution…vengeance…to warn. \n"
              + "Among the living, few intuit their presence.",
          7,
          "Heather Graham",
          "Fiction",
          "Shadow Market Enterprises, Inc.",
          2010,
          1002000,
          3.7
      );

      repository.saveAll(
          List.of(ChainsawMan, Twilight, Notebook, BillySummers, AmericanMarxism
              ,Together, ThePassengers, IT, MidnightSun, ShadowAndBone, GhostShadow)
      );

    };
  }
}
