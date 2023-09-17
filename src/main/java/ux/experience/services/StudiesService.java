package ux.experience.services;

import org.springframework.stereotype.Service;
import ux.experience.domain.Studies;
import ux.experience.repositories.StudiesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudiesService {

    private final StudiesRepository studiesRepository;

    public StudiesService(StudiesRepository studiesRepository) {
        this.studiesRepository = studiesRepository;
    }

    public Studies save(Studies study){
        return studiesRepository.save(study);
    }

    public Studies update(Studies study){
        return studiesRepository.save(study);
    }

    public List<Studies> findAll(){
        return studiesRepository.findAll();
    }

    public Optional<Studies> findOne(Long id){
        return studiesRepository.findById(id);
    }

    public void delete(Long id){
        studiesRepository.deleteById(id);
    }
}
