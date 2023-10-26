package pe.edu.upc.schedule.jorgelaban.model.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeacherJorgeLabanRepository extends JpaRepository<TeacherJorgeLaban, Integer> {

    Optional<TeacherJorgeLaban> findByCode(String code);
    List<TeacherJorgeLaban> findByCode(String code1,String code2);

    @Query("SELECT * FROM teachersJorgeLaban code BETWEEN: code1 AND: code2", nativeQuery = true)
    List<TeacherJorgeLaban> sqlCodeBetween(String code1, String code2);

}
