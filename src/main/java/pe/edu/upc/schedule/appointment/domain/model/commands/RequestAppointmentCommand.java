package pe.edu.upc.schedule.appointment.domain.model.commands;

public record RequestAppointmentCommand(Integer studentId, Integer professorId) {
}
