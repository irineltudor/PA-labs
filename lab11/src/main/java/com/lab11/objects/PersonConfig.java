package com.lab11.objects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args -> {
            Person irinel = new Person (
                    "Irinel",
                    "irinel@gmail.com",
                    LocalDate.of(2000, Month.SEPTEMBER,11)
            );

            Person andrei = new Person (
                    "andrei",
                    "andrei@gmail.com",
                    LocalDate.of(2000, Month.APRIL,21)
            );

            repository.saveAll(List.of(irinel,andrei));
        };
    }
}
