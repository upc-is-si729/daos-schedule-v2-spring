package pe.edu.upc.schedule.customer.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.customer.domain.model.queryresult.TiuQuery;
import pe.edu.upc.schedule.customer.domain.service.StudentService;
import pe.edu.upc.schedule.customer.mapping.StudentMapper;
import pe.edu.upc.schedule.customer.resource.CreateStudentResource;
import pe.edu.upc.schedule.customer.resource.StudentResource;
import pe.edu.upc.schedule.shared.exception.InternalServerErrorException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("students")
public class StudentController {

  private final StudentService studentService;
  private final StudentMapper studentMapper;

  @PostMapping
  public ResponseEntity<StudentResource> save(@RequestBody CreateStudentResource resource) {
    // POST: 	DTO-Input-Request -> Entity -> DTO-Output-response
    return new ResponseEntity<>(
            studentMapper.toResource(studentService.save(studentMapper.toEntity(resource))),
            HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Student>> fetchAll() {
    return ResponseEntity.ok(studentService.fetchAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<StudentResource> fetchById(@PathVariable("id") Integer id) {
    // GET(id): None -> Entity -> DTO-Out
    return new ResponseEntity<>(
            studentMapper.toResource(studentService.fetchById(id)),
            HttpStatus.OK);
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
  public ResponseEntity<StudentResource> fetchByTiu(@PathVariable("tiu") String tiu) {
    return ResponseEntity.ok(
            studentMapper.toResource(studentService.fetchByTiu(tiu)));
  }

  @GetMapping("level/{init}/{end}")
  public ResponseEntity<List<Student>> fetchLevelBetween(@PathVariable("init") int levelInit, @PathVariable("end") int levelEnd) {
    return new ResponseEntity<>(studentService.fetchByLevelBetween(levelInit, levelEnd), HttpStatus.OK);
  }

  /*@GetMapping("tiuquery/{init}/{end}")
  public List<TiuQuery> fetchLevelBetweenTiu(@PathVariable("init") int levelInit, @PathVariable("end") int levelEnd) {
    return studentService.fetchByLevelBetweenTiu(levelInit, levelEnd);
  }*/

}
