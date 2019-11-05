package ua.kharkiv.riezvan.lessonmanager.classes.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharkiv.riezvan.lessonmanager.classes.db.entity.Class;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long> {
}
