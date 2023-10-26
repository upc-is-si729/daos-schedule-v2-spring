
import pe.edu.upc.schedule.willyvalentin.domain.model.entities.Teacher;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JPARepository<Teacher, Integer>{

    Optional<Teacher> findByTiu(String tiu);

    @Query( value = "SELECT * FROM teachers WHERE nombreApellido = :nombreApellido", nativeQuery = true)
    List<Teacher> findByNombreApellido(String nombreApellido);
}