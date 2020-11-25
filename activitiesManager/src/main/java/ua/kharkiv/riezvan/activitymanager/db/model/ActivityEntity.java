package ua.kharkiv.riezvan.activitymanager.db.model;

import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "activities")
@FilterDef(name = "tenantFilter",
        parameters = @ParamDef(
                name = "schoolId",
                type = "long"
        ), defaultCondition = "schoolId = :schoolId")
@Filter(name = "tenantFilter")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activities_seq")
    @SequenceGenerator(name = "activities_seq", sequenceName = "activities_seq", allocationSize = 1)
    private Long id;

    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "start_from", columnDefinition = "TIME")
    private LocalTime startFrom;

    @Column(name = "end_at", columnDefinition = "TIME")
    private LocalTime endAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private ActivityType name;

}
