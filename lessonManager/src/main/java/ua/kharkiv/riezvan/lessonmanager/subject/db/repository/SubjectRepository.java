package ua.kharkiv.riezvan.lessonmanager.subject.db.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kharkiv.riezvan.lessonmanager.subject.db.entity.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
