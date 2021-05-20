package com.lab11.relationship;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
@Configuration
public class RelationshipConfig {

    @Bean
    CommandLineRunner commandLineRunner1(RelationshipRepository repository)
    {
        return args -> {
            Relationship friendship1=new Relationship(
                    Long.valueOf(1),
                    Long.valueOf(2)
            );

            Relationship friendship2=new Relationship(
                    Long.valueOf(2),
                    Long.valueOf(3)
            );

            repository.saveAll(List.of(friendship1,friendship2));

        };



    }
}
