package dev.abhisek.reactive;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@Configuration
public class StudentConfig {

    @Bean
    public CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            for (int i = 0; i < 3; i++) {
                repository.save(
                        Student
                                .builder()
                                .firstName("GeneratedFirstName " + i)
                                .lastName("GeneratedLastName " + i)
                                .age(i)
                                .build()
                ).subscribe();
            }
        };
    }

    @Bean
    public ConnectionFactoryInitializer connectionFactoryInitializer(ConnectionFactory factory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(factory);
        initializer.setDatabasePopulator(
                new ResourceDatabasePopulator(
                        new ClassPathResource("schema.sql")
                )
        );
        return initializer;
    }
}
