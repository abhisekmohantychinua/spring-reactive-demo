package dev.abhisek.reactive;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repo;

    public Flux<Student> getStudentByFirstName(String firstName) {
        return repo.findByFirstNameContainingIgnoreCase(firstName).delayElements(Duration.ofSeconds(2));
    }

    public Mono<Student> getStudentById(int id) {
        return repo.findById(id);
    }

    public Flux<Student> getAllStudent() {
        return repo.findAll().delayElements(Duration.ofSeconds(2));
    }

    public Flux<Student> getAllStudentByAge(int age) {
        return repo.findAllByAge(age).delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> addStudent(Student student) {
        return repo.save(student);
    }


    public Flux<Student> getStudentByLastName(String lastName) {
        return repo.findAllByLastNameContainingIgnoreCase(lastName).delayElements(Duration.ofSeconds(2));
    }
}
