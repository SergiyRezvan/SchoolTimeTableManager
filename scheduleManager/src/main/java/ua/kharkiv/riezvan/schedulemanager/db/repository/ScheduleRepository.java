package ua.kharkiv.riezvan.schedulemanager.db.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kharkiv.riezvan.schedulemanager.db.model.ScheduleEntity;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {
}
