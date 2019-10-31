package ua.kharkiv.riezvan.activitymanager.db.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kharkiv.riezvan.activitymanager.db.model.ScheduleEntity;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {
}
