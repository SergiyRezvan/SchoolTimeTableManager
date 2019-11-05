package ua.kharkiv.riezvan.lessonmanager.lesson.db.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kharkiv.riezvan.lessonmanager.lesson.db.entity.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
