package ua.kharkiv.riezvan.activitymanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.kharkiv.riezvan.activitymanager.api.model.ActivityManagerRq;
import ua.kharkiv.riezvan.activitymanager.api.model.ActivityManagerRs;
import ua.kharkiv.riezvan.activitymanager.converters.Converters;
import ua.kharkiv.riezvan.activitymanager.db.model.ActivityEntity;
import ua.kharkiv.riezvan.activitymanager.db.repository.ActivityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActivityManagerService {

    private final ActivityRepository activityRepository;

    public ActivityManagerRs saveActivity(ActivityManagerRq activityManagerRq) {
        var activityEntity = Converters.convertRqToDbEntity(activityManagerRq);
        return Converters.convertDbToRs(activityRepository.save(activityEntity));
    }

    public ActivityManagerRs updateActivity(ActivityManagerRq activityManagerRq, Long activityId) {
        Optional<ActivityEntity> activityEntityOpt = activityRepository.findById(activityId);
        ActivityEntity activityEntity = activityEntityOpt.orElseThrow();
        ActivityEntity updateActivity = Converters.convertRqToDbEntity(activityManagerRq);
        updateActivity.setId(activityEntity.getId());
        return Converters.convertDbToRs(activityRepository.save(updateActivity));
    }

    public ActivityManagerRs getActivityById(Long activityId) {
        if (!activityRepository.existsById(activityId)) {
            throw new NoSuchElementException("Activity " + activityId + " doesn't exists");
        }
        return Converters.convertDbToRs(activityRepository.findById(activityId).get());
    }

    public void delete(Long activityId) {
        if (!activityRepository.existsById(activityId)) {
            throw new NoSuchElementException("Activity " + activityId + " doesn't exists");
        }
        activityRepository.deleteById(activityId);
    }

    public List<ActivityManagerRs> getActivities() {
        var activities = new ArrayList<ActivityManagerRs>();
        activityRepository.findAll()
                .forEach(activityEntity -> activities.add(Converters.convertDbToRs(activityEntity)));
        return activities;
    }

}
