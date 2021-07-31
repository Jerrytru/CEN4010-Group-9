package com.example.demo.author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AuthorConfig {

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository repository){
        return args -> {
            Author mark =  new Author(
                  "Mark",
                   "Twain",
                   "This is the bio of the author" ,
                    "This is the Publisher"
            );
            Author king =  new Author(
                    "Stephen",
                    "King",
                    "This is the bio of the author" ,
                    "This is the Publisher"
            );


            repository.saveAll(List.of(mark, king));
        };
    }
}


