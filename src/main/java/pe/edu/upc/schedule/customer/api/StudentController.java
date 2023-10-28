package pe.edu.upc.schedule.customer.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.domain.model.queryresult.TiuQuery;
import pe.edu.upc.schedule.customer.domain.service.StudentService;
import pe.edu.upc.schedule.shared.exception.InternalServerErrorException;

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

  @GetMapping("{id}")
  public Student fetchById(@PathVariable("id") Integer id) {
    return studentService.fetchById(id);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
    if (studentService.deleteById(id)) {
      return ResponseEntity.noContent().build();
    }
    throw new InternalServerErrorException("Student", "id", String.valueOf(id), "deleted");
  }

  @DeleteMapping("delete/{id}")
  public ResponseEntity<?> deleteByIdWithError(@PathVariable("id") Integer id) {
    if (studentService.deleteByIdWithError(id)) {
      return ResponseEntity.noContent().build();
      // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    throw new InternalServerErrorException("Student", "id", String.valueOf(id), "deleted");
    //return ResponseEntity.internalServerError().build();
    //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @GetMapping("tiu/{tiu}")
  public Student fetchTiu(@PathVariable("tiu") String tiu) {
    return studentService.fetchByTiu(tiu);
  }

  @GetMapping("level/{init}/{end}")
  public List<Student> fetchLevelBetween(@PathVariable("init") int levelInit, @PathVariable("end") int levelEnd) {
    return studentService.fetchByLevelBetween(levelInit, levelEnd);
  }

  /*@GetMapping("tiuquery/{init}/{end}")
  public List<TiuQuery> fetchLevelBetweenTiu(@PathVariable("init") int levelInit, @PathVariable("end") int levelEnd) {
    return studentService.fetchByLevelBetweenTiu(levelInit, levelEnd);
  }*/

}
