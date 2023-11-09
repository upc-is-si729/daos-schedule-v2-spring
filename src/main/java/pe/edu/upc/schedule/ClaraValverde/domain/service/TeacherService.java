package pe.edu.upc.schedule.ClaraValverde.domain.service;

import pe.edu.upc.schedule.claravalverde.domain.model.entities.Teacher4;

import java.util.Optional;

public interface TeacherService
{

    Teacher4 save(Teacher4 entity);

    Optional<Teacher4> fetchById(Integer id);
}