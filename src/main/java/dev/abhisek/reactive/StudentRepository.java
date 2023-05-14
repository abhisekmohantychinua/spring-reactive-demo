package dev.abhisek.reactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {

    Mono<Student> findById(int id);

    Flux<Student> findByFirstNameContainingIgnoreCase(String firstName);

    Flux<Student> findAllByAge(int age);

    Flux<Student> findAllByLastNameContainingIgnoreCase(String lastName);

}
