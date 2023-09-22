package ux.experience.contollers;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ux.experience.domain.Students;
import ux.experience.services.ImageUploadService;
import ux.experience.services.StudentsService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class StudentsResource {

    private final StudentsService studentsService;
    private final ImageUploadService imageUploadService;

    public StudentsResource(StudentsService studentsService, ImageUploadService imageUploadServise) {
        this.studentsService = studentsService;
        this.imageUploadService = imageUploadServise;
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

    @PostMapping(value = "/avatar")
    public ResponseEntity<Void> uploadAvatar(@RequestPart(value = "file") MultipartFile file) {
        imageUploadService.save(file);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/avatar/{studentId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getAvatar(@PathVariable("studentId") Long studentId) throws IOException {
        ByteArrayResource studentAvatar = studentsService.getStudentAvatar(studentId);
        if (studentAvatar == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentAvatar);
    }

    @GetMapping("/students")
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
