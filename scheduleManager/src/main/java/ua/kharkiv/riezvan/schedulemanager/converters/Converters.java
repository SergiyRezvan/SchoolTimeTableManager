package ua.kharkiv.riezvan.schedulemanager.converters;

import ua.kharkiv.riezvan.schedulemanager.api.models.ScheduleManagerRQ;
import ua.kharkiv.riezvan.schedulemanager.api.models.ScheduleManagerRS;
import ua.kharkiv.riezvan.schedulemanager.db.model.ScheduleEntity;

public final class Converters {

    private Converters() {}

    public static ScheduleManagerRS convertDbEntityToRs(ScheduleEntity scheduleEntity) {
        return ScheduleManagerRS.builder()
                .scheduleId(scheduleEntity.getId())
                .actualFrom(scheduleEntity.getActualFrom())
                .actualTo(scheduleEntity.getActualTo())
                .isExceptional(scheduleEntity.isExceptional())
                .build();
    }

    public static ScheduleEntity convertRqToDbEntity(ScheduleManagerRQ request) {
        var scheduleEntity = new ScheduleEntity();
        scheduleEntity.setActualFrom(request.getActualFrom());
        scheduleEntity.setActualTo(request.getActualTo());
        scheduleEntity.setExceptional(request.isExceptional());
        return scheduleEntity;
    }

}
