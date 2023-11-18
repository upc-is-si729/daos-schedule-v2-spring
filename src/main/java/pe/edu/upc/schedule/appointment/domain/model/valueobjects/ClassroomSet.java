package pe.edu.upc.schedule.appointment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ClassroomSet(String classroom, String campus) {
  public ClassroomSet() {
    this("A101", "San Isidro");
  }
  public ClassroomSet {
    if (classroom == null) {
      throw new IllegalArgumentException("El valor de classroom no puede ser null");
    }
    if (campus == null) {
      throw new IllegalArgumentException("El valor de campus no puede ser null");
    }
  }
}
