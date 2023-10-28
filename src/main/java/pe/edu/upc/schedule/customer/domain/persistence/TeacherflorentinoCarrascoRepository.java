package pe.edu.upc.schedule.customer.domain.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.schedule.customer.domain.model.entities.TeacherflorentinoCarrasco;


import java.util.List;
import java.util.Optional;

public interface TeacherflorentinoCarrascoRepository extends JpaRepository<TeacherflorentinoCarrasco, Integer>{
    // Query Method
    Optional<TeacherflorentinoCarrasco> findByFlorentinoCarrasco(String florentinoCarrasco);

    // Native Query
    @Query(value = "SELECT * FROM teacher_florentino_carrasco WHERE florentino_carrasco = :florentinoCarrasco", nativeQuery = true)
    List<TeacherflorentinoCarrasco> findByFlorentinoCarrascoNative(String florentinoCarrasco);

}
