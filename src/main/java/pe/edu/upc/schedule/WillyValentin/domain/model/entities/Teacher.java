package pe.edu.upc.schedule.customer.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank // Validation: Objeto
    @Size(min = 10, max = 50)  // Validation: Objeto
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull
    @NotBlank // Validation: Objeto
    @Size(min = 10, max = 50)
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @NotNull
    @NotBlank // Validation: Objeto
    @Size(min = 10, max = 50)
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull
    @NotBlank
    @Column(name = "phone", length = 9, nullable = false)
    private String phone;


}
