package ua.kharkiv.riezvan.schoolmanager.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharkiv.riezvan.schoolmanager.db.models.SchoolEntity;

@Repository
public interface SchoolRepository extends CrudRepository<SchoolEntity, Long> {
}
