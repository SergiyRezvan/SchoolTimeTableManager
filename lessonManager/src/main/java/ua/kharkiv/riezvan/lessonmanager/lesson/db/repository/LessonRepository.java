package ua.kharkiv.riezvan.lessonmanager.lesson.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharkiv.riezvan.lessonmanager.lesson.db.entity.Lesson;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
