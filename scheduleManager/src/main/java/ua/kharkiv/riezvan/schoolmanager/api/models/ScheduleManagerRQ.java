package ua.kharkiv.riezvan.schoolmanager.api.models;

import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import java.util.Date;

@Data
public class ScheduleManagerRQ {

    private Long id;

    @FutureOrPresent(message = "Please specify current or future date")
    private Date actualFrom;

    @FutureOrPresent(message = "Please specify current or future date")
    private Date actualTo;

    private boolean isExceptional;

}
