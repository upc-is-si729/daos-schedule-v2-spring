package pe.edu.upc.schedule.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.domain.model.queryresult.TiuQuery;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
  // 1. Utilizar los Query Methods
  Optional<Student> findByTiu(String tiu);

  List<Student> findByLevelBetween(int levelInit, int levelEnd);

  // 2. Utilizar el nativeQuery de @Query
  @Query(value = "SELECT * from students WHERE level BETWEEN :levelInit and :levelEnd", nativeQuery = true)
  List<Student> sqlLevelBetween(int levelInit, int levelEnd);

  /*@Query(value = "SELECT tiu, first_name, last_name from students WHERE level BETWEEN :levelInit and :levelEnd", nativeQuery = true)
  List<TiuQuery> sqlLevelBetweenTiu(int levelInit, int levelEnd);*/

}
