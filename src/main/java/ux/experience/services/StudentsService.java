package ux.experience.services;

import org.springframework.stereotype.Service;
import ux.experience.domain.Students;
import ux.experience.repositories.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    private final StudentsRepository studentsRepository;

    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Students save(Students student){
        return studentsRepository.save(student);
    }

    public Students update(Students student){
        return studentsRepository.save(student);
    }

    public List<Students> findAll(){
        return studentsRepository.findAll();
    }

    public Optional<Students> findOne(Long id){
        return studentsRepository.findById(id);
    }

    public void delete(Long id){
        studentsRepository.deleteById(id);
    }
}
