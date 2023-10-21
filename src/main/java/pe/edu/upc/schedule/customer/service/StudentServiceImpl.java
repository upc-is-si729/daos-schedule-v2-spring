package pe.edu.upc.schedule.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.domain.persistence.StudentRepository;
import pe.edu.upc.schedule.customer.domain.service.StudentService;

import java.util.List;
import java.util.Optional;

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

  @Override
  public Student fetchByTiu(String tiu) {
    Optional<Student> optionalStudent = studentRepository.findByTiu(tiu);
    if (optionalStudent.isPresent()) {
      return optionalStudent.get();
    }
    throw new RuntimeException("No hay el TIU a buscar");
  }

  @Override
  public List<Student> fetchByLevelBetween(int levelInit, int levelEnd) {
    //return studentRepository.findByLevelBetween(levelInit, levelEnd);
    return studentRepository.sqlLevelBetween(levelInit, levelEnd);
  }
}
