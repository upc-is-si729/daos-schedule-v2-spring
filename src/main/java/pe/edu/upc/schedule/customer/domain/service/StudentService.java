package pe.edu.upc.schedule.customer.domain.service;

import pe.edu.upc.schedule.customer.domain.model.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
  Student save(Student student);
  List<Student> fetchAll();

  Student fetchByTiu(String tiu);

  List<Student> fetchByLevelBetween(int levelInit, int levelEnd);
}
