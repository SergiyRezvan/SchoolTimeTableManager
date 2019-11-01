package ua.kharkiv.riezvan.activitymanager.converters;

import ua.kharkiv.riezvan.activitymanager.api.model.ActivityManagerRq;
import ua.kharkiv.riezvan.activitymanager.api.model.ActivityManagerRs;
import ua.kharkiv.riezvan.activitymanager.db.model.ActivityEntity;
import ua.kharkiv.riezvan.activitymanager.db.model.ActivityType;

public final class Converters {

    private Converters() {}

    public static ActivityManagerRs convertDbToRs(ActivityEntity activityEntity) {
        return ActivityManagerRs.builder()
                .activityId(activityEntity.getId())
                .startFrom(activityEntity.getStartFrom())
                .endAt(activityEntity.getEndAt())
                .name(activityEntity.getName().name())
                .build();
    }

    public static ActivityEntity convertRqToDbEntity(ActivityManagerRq activityManagerRq) {
        var activityEntity = new ActivityEntity();
        activityEntity.setId(activityManagerRq.getId());
        activityEntity.setName(ActivityType.valueOf(activityManagerRq.getName()));
        activityEntity.setStartFrom(activityManagerRq.getStartFrom());
        activityEntity.setEndAt(activityManagerRq.getEndAt());
        return activityEntity;
    }

}
