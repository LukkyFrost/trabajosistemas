import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cosarepository extends CrudRepository<Pais, Capital> {
}