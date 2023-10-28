package pe.edu.upc.schedule.andresdoig.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "teachers3")
public class Teacher3 {
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
  @Size(min = 8, max = 12)
  @Column(name = "num_documento", length = 12, nullable = false)
  private String numDocumento;

  @NotNull
  @NotBlank
  @Size(min = 9, max = 10)
  @Column(name = "codigo", length = 10, nullable = false)  // u201712256
  private String codigo;

  @Past
  @Column(name = "birth_date")
  @Temporal(TemporalType.DATE)
  private Date birthDate; // lower Camel Case

  

}

