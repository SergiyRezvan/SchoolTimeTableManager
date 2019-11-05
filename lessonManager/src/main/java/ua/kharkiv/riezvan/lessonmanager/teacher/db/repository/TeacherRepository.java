package ua.kharkiv.riezvan.lessonmanager.teacher.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharkiv.riezvan.lessonmanager.teacher.db.entity.Teacher;

import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    Optional<Teacher> findTeacherByUserName(String userName);

}
