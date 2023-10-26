package pe.edu.upc.schedule.willyvalentin.domain.service;
import pe.edu.upc.schedule.willyvalentin.domain.model.entities.Teacher;
import pe.edu.upc.schedule.willyvalentin.domain.model.queryresult.TiuQuery;

import java.util.List;
import java.util.Optional;


public interface TeacherService
{
    Teacher save(Teacher entity);

    Teacher update(Teacher teacher);

    List<Teacher> fetchAll();

    Optional<Teacher> fetchById(Integer id);
}