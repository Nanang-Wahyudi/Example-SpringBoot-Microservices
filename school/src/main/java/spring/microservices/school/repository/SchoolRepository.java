package spring.microservices.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.microservices.school.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
}
