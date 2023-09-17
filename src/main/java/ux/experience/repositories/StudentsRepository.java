package ux.experience.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ux.experience.domain.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
}
