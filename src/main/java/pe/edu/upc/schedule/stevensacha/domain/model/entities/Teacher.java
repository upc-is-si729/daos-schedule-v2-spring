package pe.edu.upc.schedule.stevensacha.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @Past
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate; // lower Camel Case

    @NotNull
    @NotBlank
    @Size(min = 8, max = 12)
    @Column(name = "num_document", length = 12, nullable = false)
    private String numDocument;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 10)
    @Column(name = "code", length = 10, nullable = false)
    private String code;
}
