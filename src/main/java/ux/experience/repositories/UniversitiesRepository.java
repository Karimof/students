package ux.experience.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ux.experience.domain.Universities;

@Repository
public interface UniversitiesRepository extends JpaRepository<Universities, Long> {
}
