package dev.abhisek.reactive;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {

    Optional<Student> findById(int id);

    Optional<Student> findByFirstName(String firstName);

    Flux<Student> findAllByAge(int age);

}
