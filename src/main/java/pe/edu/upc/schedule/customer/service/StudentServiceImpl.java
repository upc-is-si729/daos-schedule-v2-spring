package pe.edu.upc.schedule.customer.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

  @Transactional
  @Override
  public Student save(Student student) {
    Set<ConstraintViolation<Student>> violations = validator.validate(student);
    if(violations.isEmpty()) {
      return studentRepository.save(student);
    }
    throw new ResourceValidationException("Student", violations);
  }

  @Transactional
  @Override
  public Student update(Student student) {
    return null;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Student> fetchAll() {
    return studentRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Student fetchById(Integer id) {
    if (studentRepository.existsById(id)) { // cuando la respuesta de busqueda es un solo elemento
      return studentRepository.findById(id).orElseThrow();
    }
    throw new FetchIdNotFoundException("Student", id);
  }

  @Transactional
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

  @Transactional
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

  @Transactional(readOnly = true)
  @Override
  public Student fetchByTiu(String tiu) {
    if (studentRepository.existsByTiu(tiu)) {
      return studentRepository.findByTiu(tiu).orElseThrow();
    }
    throw new FetchNotFoundException("Student", "tiu", tiu);
  }

  @Transactional(readOnly = true)
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
