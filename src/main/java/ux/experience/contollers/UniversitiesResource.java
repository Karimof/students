package ux.experience.contollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ux.experience.domain.Students;
import ux.experience.domain.Universities;
import ux.experience.services.UniversitiesService;

import java.util.List;
import java.util.Optional;

@RestController
public class UniversitiesResource {

    private final UniversitiesService universitiesService;

    public UniversitiesResource(UniversitiesService universitiesService) {
        this.universitiesService = universitiesService;
    }


    @PostMapping("/universities")
    public ResponseEntity<Universities> createUniversity(@RequestBody Universities universities) {
        Universities result = universitiesService.save(universities);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/universities")
    public ResponseEntity<Universities> updateUniversity(@RequestBody Universities universities) {
        Universities result = universitiesService.save(universities);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/universities/page/{page}")
    public ResponseEntity<List<Universities>> getAllUniversities(@PathVariable(required = false) Integer page) {
        List<Universities> result = universitiesService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/universities/{id}")
    public ResponseEntity<Universities> getUniversity(@PathVariable Long id) {
        Optional<Universities> result = universitiesService.findOne(id);
        return ResponseEntity.ok(result.orElse(null));
    }

    @DeleteMapping("/universities/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        universitiesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
