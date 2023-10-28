package pe.edu.upc.schedule.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.customer.domain.model.entities.TeacherGiakomoCausso;


import java.util.List;

@Repository
public interface TeacherGiakomoCaussoRepository extends JpaRepository<TeacherGiakomoCausso, Long> {



    @Query(value = "SELECT * FROM teacher_giakomo_causso WHERE giakomo_causso = :giakomocausso", nativeQuery = true)
    List<TeacherGiakomoCausso> findByGiakomoCaussoNative(String GiakomoCausso);
}
