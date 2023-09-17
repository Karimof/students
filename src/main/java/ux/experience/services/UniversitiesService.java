package ux.experience.services;

import org.springframework.stereotype.Service;
import ux.experience.domain.Universities;
import ux.experience.repositories.UniversitiesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversitiesService {

    private final UniversitiesRepository universitiesRepository;

    public UniversitiesService(UniversitiesRepository universitiesRepository) {
        this.universitiesRepository = universitiesRepository;
    }

    public Universities save(Universities university){
        return universitiesRepository.save(university);
    }

    public Universities update(Universities university){
        return universitiesRepository.save(university);
    }

    public List<Universities> findAll(){
        return universitiesRepository.findAll();
    }

    public Optional<Universities> findOne(Long id){
        return universitiesRepository.findById(id);
    }

    public void delete(Long id){
        universitiesRepository.deleteById(id);
    }
}
