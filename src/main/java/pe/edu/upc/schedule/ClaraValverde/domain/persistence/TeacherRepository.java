
import pe.edu.upc.schedule.claravalverde.domain.model.entities.Teacher;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JPARepository<Teacher, Integer>{

    Optional<Teacher> findByTiu(String tiu);

    @Query(value = "SELECT * FROM teachers WHERE tiu = :tiu", nativeQuery = true)

}