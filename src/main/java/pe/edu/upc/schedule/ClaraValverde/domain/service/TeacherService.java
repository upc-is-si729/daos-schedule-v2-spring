package pe.edu.upc.schedule.claravalverde.domain.service;
import pe.edu.upc.schedule.claravalverde.domain.model.entities.Teacher;
import pe.edu.upc.schedule.claravalverde.domain.model.queryresult.TiuQuery;

import java.util.List;
import java.util.Optional;


public interface TeacherService
{
    Teacher save(Teacher entity);

    Optional<Teacher> fetchById(Integer id);
}