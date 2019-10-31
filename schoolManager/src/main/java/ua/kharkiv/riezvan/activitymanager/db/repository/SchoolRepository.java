package ua.kharkiv.riezvan.activitymanager.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharkiv.riezvan.activitymanager.db.models.SchoolEntity;

@Repository
public interface SchoolRepository extends CrudRepository<SchoolEntity, Long> {
}
