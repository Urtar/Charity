package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

@Transactional
@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Long> {

    List<Institution> findAll();
}
