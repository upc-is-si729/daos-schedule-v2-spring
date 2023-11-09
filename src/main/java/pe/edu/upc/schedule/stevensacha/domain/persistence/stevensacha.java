package pe.edu.upc.schedule.stevensacha.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.stevensacha.domain.model.entities.Teacher8;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface stevensacha extends JpaRepository<Teacher8,Integer> {
    //Optional<Teacher8> findByNumDocument(String numDocument);

    //@Query(value = "SELECT * from teachers8 WHERE birhtDate BETWEEN :birthDateInit and :birhtDateEnd", nativeQuery = true)
    //List<Teacher8> sqlBirthDateBetween(Date birthDateInit, Date birthDateEnd);

}
