package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import models.Paismodelo;
@Repository
public interface CosaRepository extends CrudRepository<Paismodelo, Long> {
}