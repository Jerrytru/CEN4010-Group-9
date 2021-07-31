package com.example.demo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner2(BookRepository repository){
        return args -> {
            Book gatsby =  new Book(
                    12345,
                    "The Great Gatsby",
                    "Love story in the roaring 20's",
                    12.5,
                    "F Scott Fitz",
                    "Fiction",
                    "Penguin",
                    1934,
                    22000000,
                    4.0
            );
            Book monteCristo =  new Book(
                    54321,
                    "Count of Monte Cristo",
                    "Adventure and revenge",
                    12.5,
                    "Dumas",
                    "Fiction",
                    "Penguin",
                    1834,
                    52000000,
                    5.0
            );

            Book ChainsawMan = new Book(
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

            Book Twilight = new Book(
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

            Book Notebook = new Book(
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

            Book BillySummers = new Book(
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

            Book AmericanMarxism = new Book(
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

            Book Together = new Book(
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

            Book ThePassengers = new Book(
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

            Book IT = new Book(
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

            Book MidnightSun = new Book(
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

            Book ShadowAndBone = new Book(
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

            Book GhostShadow = new Book(
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

            repository.saveAll(List.of(gatsby, monteCristo, ChainsawMan, Twilight, Notebook, BillySummers, AmericanMarxism
                    ,Together, ThePassengers, IT, MidnightSun, ShadowAndBone, GhostShadow));
        };
    }
}
