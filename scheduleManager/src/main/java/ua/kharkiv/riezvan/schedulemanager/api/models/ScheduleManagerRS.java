package ua.kharkiv.riezvan.schedulemanager.api.models;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ScheduleManagerRS {

    @EqualsAndHashCode.Include
    private Long scheduleId;

    private Date actualFrom;

    private Date actualTo;

    private boolean isExceptional;

}
