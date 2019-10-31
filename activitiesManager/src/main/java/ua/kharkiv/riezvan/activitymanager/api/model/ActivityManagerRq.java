package ua.kharkiv.riezvan.activitymanager.api.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ActivityManagerRq {

    private Long id;

    private Long schoolId;

    private LocalTime startFrom;

    private LocalTime endAt;

    private String name;

}
