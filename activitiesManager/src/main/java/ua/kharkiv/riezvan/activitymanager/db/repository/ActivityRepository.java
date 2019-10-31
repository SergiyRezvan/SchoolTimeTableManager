package ua.kharkiv.riezvan.activitymanager.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharkiv.riezvan.activitymanager.db.model.ActivityEntity;

@Repository
public interface ActivityRepository extends CrudRepository<ActivityEntity, Long> {
}
