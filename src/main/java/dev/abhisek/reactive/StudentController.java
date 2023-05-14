package dev.abhisek.reactive;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student/")
public class StudentController {

    private final StudentService service;

    @PostMapping
    public ResponseEntity<Mono<Student>> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(service.addStudent(student));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Mono<Student>> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping("/firstname/{firstName}")
    public ResponseEntity<Flux<Student>> getStudentByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(service.getStudentByFirstName(firstName));
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<Flux<Student>> getStudentByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(service.getStudentByLastName(lastName));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<Flux<Student>> getStudentByLastName(@PathVariable int age) {
        return ResponseEntity.ok(service.getAllStudentByAge(age));
    }

    @GetMapping
    public ResponseEntity<Flux<Student>> getAllStudent() {
        return ResponseEntity.ok(service.getAllStudent());
    }

}
