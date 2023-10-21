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

  @GetMapping("tiu/{tiu}")
  public Student fetchTiu(@PathVariable("tiu") String tiu) {
    return studentService.fetchByTiu(tiu);
  }

  @GetMapping("level/{init}/{end}")
  public List<Student> fetchLevelBetween(@PathVariable("init") int levelInit, @PathVariable("end") int levelEnd) {
    return studentService.fetchByLevelBetween(levelInit, levelEnd);
  }

}
