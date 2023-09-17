package ux.experience.contollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ux.experience.domain.Students;
import ux.experience.services.StudentsService;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentsResource {

    private final StudentsService studentsService;

    public StudentsResource(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("/students")
    public ResponseEntity<Students> createStudent(@RequestBody Students students) {
        Students result = studentsService.save(students);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/students")
    public ResponseEntity<Students> updateStudent(@RequestBody Students students) {
        Students result = studentsService.save(students);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/students/page/{page}")
    public ResponseEntity<List<Students>> getAllStudents(@PathVariable(required = false) Integer page) {
        List<Students> result = studentsService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Students> getStudent(@PathVariable Long id) {
        Optional<Students> result = studentsService.findOne(id);
        return ResponseEntity.ok(result.orElse(null));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
