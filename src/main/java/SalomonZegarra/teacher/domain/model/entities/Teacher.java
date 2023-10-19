package SalomonZegarra.teacher.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 10)
    @Column(name = "code", length = 10, nullable = false)
    private String code;

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
