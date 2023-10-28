package pe.edu.upc.schedule.salomonzegarra.domain.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.schedule.salomonzegarra.domain.model.entities.Teacher6;

import java.util.List;
import java.util.Optional;

public interface Teacher6Repository extends JpaRepository<Teacher6, Integer> {
    //Query Methods
    Optional<Teacher6> findByCode(String code);

    //Native Query
    @Query(value = "SELECT * from teachers6 WHERE id EQUALS idToFind", nativeQuery = true)
    List<Teacher6> sqlGetById(int idToFind);
}
