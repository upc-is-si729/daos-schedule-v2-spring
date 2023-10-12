package pe.edu.upc.schedule.customer.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "last_name", length = 50)
  private String lastName;

  @Column(name = "first_name", length = 50)
  private String firstName;
}
