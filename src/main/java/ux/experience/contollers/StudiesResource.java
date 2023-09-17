package ux.experience.contollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ux.experience.domain.Studies;
import ux.experience.services.StudiesService;

import java.util.List;
import java.util.Optional;

@RestController
public class StudiesResource {

    private final StudiesService studiesService;

    public StudiesResource(StudiesService studiesService) {
        this.studiesService = studiesService;
    }

    @PostMapping("/studies")
    public ResponseEntity<Studies> createStudies(@RequestBody Studies studies) {
        Studies result = studiesService.save(studies);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/studies")
    public ResponseEntity<Studies> updateStudies(@RequestBody Studies studies) {
        Studies result = studiesService.save(studies);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/studies/page/{page}")
    public ResponseEntity<List<Studies>> getAllStudies(@PathVariable(required = false) Integer page) {
        List<Studies> result = studiesService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/studies/{id}")
    public ResponseEntity<Studies> getStudies(@PathVariable Long id) {
        Optional<Studies> result = studiesService.findOne(id);
        return ResponseEntity.ok(result.orElse(null));
    }

    @DeleteMapping("/studies/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studiesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
