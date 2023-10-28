package pe.edu.upc.schedule.customer.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.domain.model.queryresult.TiuQuery;
import pe.edu.upc.schedule.customer.domain.persistence.StudentRepository;
import pe.edu.upc.schedule.customer.domain.service.StudentService;
import pe.edu.upc.schedule.shared.exception.ResourceNotFoundException;
import pe.edu.upc.schedule.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  private final Validator validator;

  @Override
  public Student save(Student student) {
    Set<ConstraintViolation<Student>> violations = validator.validate(student);
    if(violations.isEmpty()) {
      return studentRepository.save(student);
    }
    throw new ResourceValidationException("Student", violations);
  }

  @Override
  public Student update(Student student) {
    return null;
  }

  @Override
  public List<Student> fetchAll() {
    return studentRepository.findAll();
  }

  @Override
  public Optional<Student> fetchById(Integer id) {
    return Optional.empty();
  }

  @Override
  public boolean deleteById(Integer id) {
    return false;
  }

  @Override
  public Student fetchByTiu(String tiu) {
    Optional<Student> optionalStudent = studentRepository.findByTiu(tiu);
    if (optionalStudent.isPresent()) {
      return optionalStudent.get();
    }
    throw new ResourceNotFoundException("Student", "tiu", tiu);
  }

  @Override
  public List<Student> fetchByLevelBetween(int levelInit, int levelEnd) {
    //return studentRepository.findByLevelBetween(levelInit, levelEnd);
    return studentRepository.sqlLevelBetween(levelInit, levelEnd);
  }

  /*@Override
  public List<TiuQuery> fetchByLevelBetweenTiu(int levelInit, int levelEnd) {
    return studentRepository.sqlLevelBetweenTiu(levelInit, levelEnd);
  }*/


}
