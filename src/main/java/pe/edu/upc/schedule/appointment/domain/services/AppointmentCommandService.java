package pe.edu.upc.schedule.appointment.domain.services;

import pe.edu.upc.schedule.appointment.domain.model.commands.RequestAppointmentCommand;

public interface AppointmentCommandService {
  Integer handle(RequestAppointmentCommand command);
}
