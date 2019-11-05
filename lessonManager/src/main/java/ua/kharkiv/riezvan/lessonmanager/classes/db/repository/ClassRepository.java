package ua.kharkiv.riezvan.lessonmanager.classes.db.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kharkiv.riezvan.lessonmanager.classes.db.entity.Class;

public interface ClassRepository extends CrudRepository<Class, Long> {
}
