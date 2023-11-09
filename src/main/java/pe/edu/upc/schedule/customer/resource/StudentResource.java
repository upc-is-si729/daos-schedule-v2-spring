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
public class StudentResource {  // DTO - Output
  private String tiu;
  private String lastName;  // name: snake, singular
  private String firstName;
  private int level;
}
