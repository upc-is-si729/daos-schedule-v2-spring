package pe.edu.upc.schedule.customer.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.domain.service.StudentService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("students")
public class StudentController {

  private final StudentService studentService;


  @PostMapping
  public Student save(@RequestBody Student student) {
    return studentService.save(student);
  }

  @GetMapping
  public List<Student> fetchAll() {
    return studentService.fetchAll();
  }

}
