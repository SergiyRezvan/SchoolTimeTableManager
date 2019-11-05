package ua.kharkiv.riezvan.lessonmanager.subject.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharkiv.riezvan.lessonmanager.subject.db.entity.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
