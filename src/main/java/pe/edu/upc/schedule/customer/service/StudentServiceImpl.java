package pe.edu.upc.schedule.customer.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.domain.persistence.StudentRepository;
import pe.edu.upc.schedule.customer.domain.service.StudentService;
import pe.edu.upc.schedule.shared.exception.FetchIdNotFoundException;
import pe.edu.upc.schedule.shared.exception.FetchNotFoundException;
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
  public Student fetchById(Integer id) {
    if (studentRepository.existsById(id)) { // cuando la respuesta de busqueda es un solo elemento
      return studentRepository.findById(id).orElseThrow();
    }
    throw new FetchIdNotFoundException("Student", id);
  }

  @Override
  public boolean deleteById(Integer id) {
    if (studentRepository.existsById(id)) { // cuando la respuesta de busqueda es un solo elemento
      studentRepository.deleteById(id);
      if (studentRepository.existsById(id)) // Validar que se elimino
        return false;
      return true;
    }
    throw new FetchIdNotFoundException("Student", id);
  }
  @Override
  public boolean deleteByIdWithError(Integer id) {
    if (studentRepository.existsById(id)) { // cuando la respuesta de busqueda es un solo elemento
      studentRepository.deleteById(id+100);
      if (studentRepository.existsById(id)) // Validar que se elimino
        return false;
      return true;
    }
    throw new FetchIdNotFoundException("Student", id);
  }

  @Override
  public Student fetchByTiu(String tiu) {
    if (studentRepository.existsByTiu(tiu)) {
      studentRepository.findByTiu(tiu).orElseThrow();
    }
    throw new FetchNotFoundException("Student", "tiu", tiu);
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
