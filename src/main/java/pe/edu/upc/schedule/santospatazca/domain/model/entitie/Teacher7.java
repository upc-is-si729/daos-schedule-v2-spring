package pe.edu.upc.schedule.santospatazca.domain.model.entitie;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "teachers7")
public class Teacher7 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @NotNull
    @NotBlank // Validation: Objeto
    @Size(min = 2, max = 50)  // Validation: Objeto
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 10)
    @Column(name = "codigo", length = 10, nullable = false)
    private String codigo;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 12)
    @Column(name = "num_documento", length = 12, nullable = false)
    private String numDocumento;

    @Past
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;


}
