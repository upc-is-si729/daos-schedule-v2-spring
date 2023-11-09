
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@Tag(name = "teachers", description = "Everything about the teachers")
@AllArgsConstructor
@RestController
@RequestMapping("teachers")
public class TeacherController  {


    @Operation(
            summary = "Get a student by an ID given",
            description = "Return a student by an ID given",
            operationId = "fetchById",
            responses = {
                    @ApiResponse (
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StudentResource.class)
                            )
                    ),
                    @ApiResponse (
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<StudentResource> fetchById(@PathVariable("id") Integer id) {
        // GET(id): None -> Entity -> DTO-Out
        return new ResponseEntity<>(
                studentMapper.toResource(studentService.fetchById(id)),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentResource> save(@RequestBody CreateStudentResource resource) {
        // POST: 	DTO-In -> Entity -> DTO-Out
        return new ResponseEntity<>(
                studentMapper.toResource(studentService.save(studentMapper.toEntity(resource))),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> fetchAll() {
        return ResponseEntity.ok(studentService.fetchAll());
    }
}