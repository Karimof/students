package ux.experience.services;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import ux.experience.domain.Students;
import ux.experience.repositories.StudentsRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    private final StudentsRepository studentsRepository;

    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Students save(Students student) {
        student.setCreatedAt(LocalDateTime.now());
        return studentsRepository.save(student);
    }

    public Students update(Students student) {
        return studentsRepository.save(student);
    }

    public List<Students> findAll() {
        return studentsRepository.findAll();
    }

    public Optional<Students> findOne(Long id) {
        return studentsRepository.findById(id);
    }

    public ByteArrayResource getStudentAvatar(Long studentId) {
        Optional<Students> optStudent = findOne(studentId);
        if (optStudent.isPresent()) {
            Students student = optStudent.get();
            Path absolutePath = Paths.get(
                    "D:/Programming/Projects/Experience projects/students/src/main/resources/avatars/"
                            + student.getAvatar());
            ByteArrayResource inputStream = null;
            try {
                inputStream = new ByteArrayResource(Files.readAllBytes(absolutePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return inputStream;
        } else return null;
    }

    public void delete(Long id) {
        studentsRepository.deleteById(id);
    }
}
