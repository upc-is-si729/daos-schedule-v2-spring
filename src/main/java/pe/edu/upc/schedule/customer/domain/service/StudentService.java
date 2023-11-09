package pe.edu.upc.schedule.customer.domain.service;

import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.domain.model.queryresult.TiuQuery;

import java.util.List;
import java.util.Optional;

public interface StudentService {
  Student save(Student student);

  Student update(Student student);

  List<Student> fetchAll();

  Student fetchById(Integer id);

  boolean deleteById(Integer id);

  boolean deleteByIdWithError(Integer id);

  Student fetchByTiu(String tiu);

  List<Student> fetchByLevelBetween(int levelInit, int levelEnd);

  //List<TiuQuery> fetchByLevelBetweenTiu(int levelInit, int levelEnd);


}
