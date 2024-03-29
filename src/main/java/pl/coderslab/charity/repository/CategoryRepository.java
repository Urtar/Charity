package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Category;

import java.util.List;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


//    List<Category> findAll();
}
