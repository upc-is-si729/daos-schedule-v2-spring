package pe.edu.upc.schedule.appointment.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.schedule.shared.domain.model.entities.AuditableModel;

@Getter
@Entity
@Table(name = "professors")
public class Professor extends AuditableModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;

  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;
}
