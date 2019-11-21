package ua.kharkiv.riezvan.activitymanager.api.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Data
public class ActivityManagerRq {

    private Long id;

    private Long schoolId;

    @NotBlank
    private LocalTime startFrom;

    @NotBlank
    private LocalTime endAt;
    @NotBlank
    private String name;

}
