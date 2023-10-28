package pe.edu.upc.schedule.SergioBazan.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.SergioBazan.domain.model.entities.TeacherSergioBazan;

import java.util.Date;
import java.util.List;

@Repository
public interface TeacherSergioBazanRepository extends JpaRepository<TeacherSergioBazan, Integer> {

  @Query(value = "SELECT * FROM TeacherSergioBazan WHERE birthDate BETWEEN :first and :last ", nativeQuery = true)
  List<TeacherSergioBazan> getBetweenBirthDate(Date first, Date second);
}
