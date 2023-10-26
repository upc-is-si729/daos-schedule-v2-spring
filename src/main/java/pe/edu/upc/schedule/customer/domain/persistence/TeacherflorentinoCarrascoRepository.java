package pe.edu.upc.schedule.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.customer.domain.model.entities.TeacherflorentinoCarrasco;


import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherflorentinoCarrascoRepository extends JpaRepository<TeacherflorentinoCarrasco, Long> {



    @Query(value = "SELECT * FROM teacher_florentino_carrasco WHERE florentino_carrasco = :florentinoCarrasco", nativeQuery = true)
    List<TeacherflorentinoCarrasco> findByFlorentinoCarrascoNative(String florentinoCarrasco);
}
