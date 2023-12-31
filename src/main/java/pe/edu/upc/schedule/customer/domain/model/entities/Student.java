package pe.edu.upc.schedule.customer.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "students") // plural, snake  // CREATE TABLE
public class Student {

  @Id // PRIMARY KEY
  @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT o SEQUENCE
  private Integer id;

  @NotNull
  @NotBlank // Validation: Objeto
  @Size(min = 2, max = 50)  // Validation: Objeto
  @Column(name = "last_name", length = 50, nullable = false)  // Validation: tabla
  private String lastName;  // name: snake, singular

  @NotNull
  @NotBlank // Validation: Objeto
  @Size(min = 2, max = 50)  // Validation: Objeto
  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;

  @NotNull
  @NotBlank
  @Size(min = 9, max = 10)
  @Column(name = "tiu", length = 10, nullable = false)  // u201812236
  private String tiu;

  @NotNull
  @NotBlank
  @Size(min = 8, max = 12)
  @Column(name = "num_documento", length = 12, nullable = false)
  private String numDocumento;

  @Past
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "birth_date")
  @Temporal(TemporalType.DATE)
  private Date birthDate; // lower Camel Case


  @Min(value = 1)
  @Max(value = 14)
  @Column(name = "level", columnDefinition = "smallint")
  private int level;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "career_id")
  private Career career;

}
