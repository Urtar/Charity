package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;

import java.util.List;

@Transactional
@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {

    List<Donation> findAll();
}
