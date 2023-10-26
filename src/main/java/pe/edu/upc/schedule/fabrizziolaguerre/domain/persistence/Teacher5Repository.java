package pe.edu.upc.schedule.fabrizziolaguerre.domain.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.customer.domain.model.entities.Teacher;


import java.util.List;
import java.util.Optional;
@Repository
public interface Teacher5Repository extends JpaRepository<Teacher, Integer>{
    // 1. Utilizar los Query Methods
    Optional<Teacher> findByFabrizzioLaguerre(String fabrizzioLaguerre);

    // 2. Utilizar el nativeQuery de @Query
    @Query(value = "SELECT * from teacher WHERE level BETWEEN :levelInit and :levelEnd", nativeQuery = true)
    List<Teacher> sqlLevelBetween(int levelInit, int levelEnd);



}
