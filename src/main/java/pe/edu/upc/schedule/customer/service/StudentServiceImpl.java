package pe.edu.upc.schedule.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.domain.persistence.StudentRepository;
import pe.edu.upc.schedule.customer.domain.service.StudentService;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  @Override
  public Student save(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public List<Student> fetchAll() {
    return studentRepository.findAll();
  }
}
