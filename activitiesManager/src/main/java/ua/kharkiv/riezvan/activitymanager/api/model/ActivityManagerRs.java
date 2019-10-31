package ua.kharkiv.riezvan.activitymanager.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalTime;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ActivityManagerRs extends ResourceSupport {

    @EqualsAndHashCode.Include
    private Long activityId;

    private Long schoolId;

    private LocalTime startFrom;

    private LocalTime endAt;

    private String name;

}
