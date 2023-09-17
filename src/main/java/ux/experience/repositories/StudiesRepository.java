package ux.experience.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ux.experience.domain.Studies;

@Repository
public interface StudiesRepository extends JpaRepository<Studies, Long> {
}
