package pe.edu.upc.schedule.customer.domain.service;

import pe.edu.upc.schedule.customer.domain.model.entities.Student;

import java.util.List;

public interface StudentService {
  Student save(Student student);
  List<Student> fetchAll();
}
