package pe.edu.upc.schedule.appointment.domain.model.aggregates;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import pe.edu.upc.schedule.appointment.domain.model.entities.Professor;
import pe.edu.upc.schedule.appointment.domain.model.valueobjects.ClassroomSet;
import pe.edu.upc.schedule.customer.domain.model.entities.Student;
import pe.edu.upc.schedule.shared.domain.model.entities.AuditableModel;

import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment extends AuditableModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "professor_id")
  private Professor professor;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id")
  private Student Student;

  @Embedded
  private ClassroomSet classroom;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "date_appointment")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

}
