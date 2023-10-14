package pe.edu.upc.schedule.customer.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "students") // plural, snake  // CREATE TABLE
public class Student {

  @Id // PRIMARY KEY
  @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT o SEQUENCE
  private Integer id;

  // name: snake, singular
  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;

  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;

  @Column(name = "tiu", length = 10, nullable = false)
  private String tiu;

  @Column(name = "num_documento", length = 20, nullable = false)
  private String numDocumento;

  @Column(name = "birth_date")
  @Temporal(TemporalType.DATE)
  private Date birthDate; // lower Camel Case

  @Column(name = "level", columnDefinition = "smallint")
  private int level;

}
