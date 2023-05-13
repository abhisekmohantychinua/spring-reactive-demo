package dev.abhisek.reactive;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student/")
public class StudentController {

    private final StudentService service;

    @PostMapping
    public ResponseEntity<Mono<Student>> addStudent(@RequestBody Student student) {
        return ResponseEntity
                .ok(service.addStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(
                service
                        .getStudentById(id)
                        .orElseThrow(NoSuchElementException::new)
        );
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<Student> getStudentByFirstName(@PathVariable String firstName) {
        return ResponseEntity
                .ok(
                        service
                                .getStudentByFirstName(firstName)
                                .orElseThrow(NoSuchElementException::new)
                );
    }

    @GetMapping
    public ResponseEntity<Flux<Student>> getAllStudent() {
        return ResponseEntity
                .ok(service.getAllStudent());
    }

}
