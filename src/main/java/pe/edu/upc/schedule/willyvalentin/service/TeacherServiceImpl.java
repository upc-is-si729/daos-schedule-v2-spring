import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.schedule.willyvalentin.domain.model.entities.Teacher;
import pe.edu.upc.schedule.willyvalentin.domain.model.queryresult.TiuQuery;
import pe.edu.upc.schedule.willyvalentin.domain.persistence.TeacherRepository;
import pe.edu.upc.schedule.willyvalentin.domain.service.TeacherService;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService{
    private final StudentRepository studentRepository;

    private final Validator validator;
}