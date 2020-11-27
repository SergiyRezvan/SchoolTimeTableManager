package ua.kharkiv.riezvan.schedulemanager.db.model;

import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "schedules")
@FilterDef(name = "tenantFilter",
        parameters = @ParamDef(
                name = "schoolId",
                type = "long"
        ), defaultCondition = "schoolId = :schoolId")
@Filter(name = "tenantFilter")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "schedules_seq")
    @SequenceGenerator(name = "schedules_seq", sequenceName = "schedules_seq", allocationSize = 1)
    private Long id;

    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "actual_from")
    @Temporal(TemporalType.DATE)
    private Date actualFrom;

    @Column(name = "actual_to")
    @Temporal(TemporalType.DATE)
    private Date actualTo;

    @Column(name = "is_exceptional")
    private boolean isExceptional;

}
