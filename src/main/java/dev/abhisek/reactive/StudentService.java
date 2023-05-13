package dev.abhisek.reactive;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repo;

    public Optional<Student> getStudentByFirstName(String firstName) {
        return repo
                .findByFirstName(firstName);
    }

    public Optional<Student> getStudentById(int id) {
        return repo
                .findById(id);
    }

    public Flux<Student> getAllStudent() {
        return repo
                .findAll();
    }

    public Flux<Student> getAllStudentByAge(int age) {
        return repo
                .findAllByAge(age);
    }

    public Mono<Student> addStudent(Student student) {
        return repo
                .save(student);
    }

    public Flux<Student> addStudents(List<Student> students) {
        return repo
                .saveAll(students);
    }
}
