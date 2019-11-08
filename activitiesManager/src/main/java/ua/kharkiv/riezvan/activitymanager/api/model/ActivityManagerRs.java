package ua.kharkiv.riezvan.activitymanager.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ActivityManagerRs {

    @EqualsAndHashCode.Include
    private Long activityId;

    private Long schoolId;

    private LocalTime startFrom;

    private LocalTime endAt;

    private String name;

}
