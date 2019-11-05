package ua.kharkiv.riezvan.lessonmanager.teacher.db.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kharkiv.riezvan.lessonmanager.teacher.db.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
