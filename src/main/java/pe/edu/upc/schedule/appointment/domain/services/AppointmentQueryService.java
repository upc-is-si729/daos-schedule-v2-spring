package pe.edu.upc.schedule.appointment.domain.services;

import pe.edu.upc.schedule.appointment.domain.model.aggregates.Appointment;
import pe.edu.upc.schedule.appointment.domain.model.queries.GetAllAppointmentQuery;
import pe.edu.upc.schedule.appointment.domain.model.queries.GetAppointmentByProfessorIdQuery;
import pe.edu.upc.schedule.appointment.domain.model.queries.GetAppointmentByStudentIdQuery;

import java.util.List;

public interface AppointmentQueryService {
  List<Appointment> handle(GetAllAppointmentQuery query);
  List<Appointment> handle(GetAppointmentByStudentIdQuery query);
  List<Appointment> handle(GetAppointmentByProfessorIdQuery query);
}
