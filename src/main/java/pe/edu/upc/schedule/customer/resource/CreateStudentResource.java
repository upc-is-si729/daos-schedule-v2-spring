package pe.edu.upc.schedule.customer.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pe.edu.upc.schedule.customer.domain.model.entities.Career;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentResource {  // DTO-Input

  @NotNull
  @NotBlank // Validation: Objeto
  @Size(min = 2, max = 50)  // Validation: Objeto
  private String lastName;  // name: snake, singular

  @NotNull
  @NotBlank // Validation: Objeto
  @Size(min = 2, max = 50)  // Validation: Objeto
  private String firstName;

  @NotNull
  @NotBlank
  @Size(min = 9, max = 10)
  private String tiu;

  @NotNull
  @NotBlank
  @Size(min = 8, max = 12)
  private String numDocumento;

  @Past
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthDate; // lower Camel Case

  @Min(value = 1)
  @Max(value = 14)
  private int level;
}
