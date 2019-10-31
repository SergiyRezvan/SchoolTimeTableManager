package ua.kharkiv.riezvan.schoolmanager.db.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kharkiv.riezvan.schoolmanager.db.model.ScheduleEntity;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {
}
