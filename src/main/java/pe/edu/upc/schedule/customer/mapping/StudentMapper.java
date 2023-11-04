package pe.edu.upc.schedule.customer.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.resource.CreateStudentResource;
import pe.edu.upc.schedule.customer.resource.StudentResource;
import pe.edu.upc.schedule.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class StudentMapper implements Serializable {

  @Autowired
  EnhancedModelMapper mapper;

  public Student toEntity(CreateStudentResource resource) {
    return this.mapper.map(resource, Student.class);
  }

  public StudentResource toResource(Student student) {
    return this.mapper.map(student, StudentResource.class);
  }
}
