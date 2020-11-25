package ua.kharkiv.riezvan.schedulemanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.kharkiv.riezvan.schedulemanager.api.models.ScheduleManagerRQ;
import ua.kharkiv.riezvan.schedulemanager.api.models.ScheduleManagerRS;
import ua.kharkiv.riezvan.schedulemanager.converters.Converters;
import ua.kharkiv.riezvan.schedulemanager.db.model.ScheduleEntity;
import ua.kharkiv.riezvan.schedulemanager.db.repository.ScheduleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ScheduleManagerService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleManagerRS saveSchedule(ScheduleManagerRQ scheduleManagerRQ) {
        ScheduleEntity savedEntity = scheduleRepository.save(Converters.convertRqToDbEntity(scheduleManagerRQ));
        return Converters.convertDbEntityToRs(savedEntity);
    }

    public ScheduleManagerRS updateSchedule(ScheduleManagerRQ scheduleManagerRQ, Long scheduleId) {
        if (!scheduleRepository.existsById(scheduleId)) {
            throw new NoSuchElementException("Schedule " + scheduleId + " doesn't exists");
        }
        ScheduleEntity scheduleEntity = Converters.convertRqToDbEntity(scheduleManagerRQ);
        scheduleEntity.setId(scheduleId);
        return Converters.convertDbEntityToRs(scheduleRepository.save(scheduleEntity));
    }

    public List<ScheduleManagerRS> getAllSchedules() {
        var allSchedules = new ArrayList<ScheduleManagerRS>();
        scheduleRepository.findAll().forEach(scheduleEntity ->
                allSchedules.add(Converters.convertDbEntityToRs(scheduleEntity)));
        return allSchedules;
    }

    public ScheduleManagerRS getSchedule(Long scheduleId) {
        Optional<ScheduleEntity> scheduleEntity = scheduleRepository.findById(scheduleId);
        return Converters.convertDbEntityToRs(scheduleEntity.orElseThrow());
    }

    public void deleteSchedule(Long scheduleId) {
        if (!scheduleRepository.existsById(scheduleId)) {
            throw new NoSuchElementException("Schedule " + scheduleId + " doesn't exists");
        }
        scheduleRepository.deleteById(scheduleId);
    }

}
