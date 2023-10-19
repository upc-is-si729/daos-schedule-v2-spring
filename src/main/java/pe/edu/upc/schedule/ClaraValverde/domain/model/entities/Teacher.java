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
    @NotBlank
    @Size(min = 10, max = 50)
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull
    @NotBlank // Validation: Objeto
    @Size(min = 10, max = 50)
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull
    @NotBlank // Validation: Objeto
    @Size(min = 10, max = 50)
    @Column(name = "phone", length = 50, nullable = false)
    private String phone;


    @NotNull
    @NotBlank // Validation: Objeto
    @Size(min = 10, max = 50)
    @Column(name = "codigo", length = 50, nullable = false)
    private String codigo;

}