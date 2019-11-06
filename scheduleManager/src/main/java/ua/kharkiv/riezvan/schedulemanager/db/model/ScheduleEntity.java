package ua.kharkiv.riezvan.schedulemanager.db.model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

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

    public ScheduleEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Date getActualFrom() {
        return actualFrom;
    }

    public void setActualFrom(Date actualFrom) {
        this.actualFrom = actualFrom;
    }

    public Date getActualTo() {
        return actualTo;
    }

    public void setActualTo(Date actualTo) {
        this.actualTo = actualTo;
    }

    public boolean isExceptional() {
        return isExceptional;
    }

    public void setExceptional(boolean exceptional) {
        isExceptional = exceptional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduleEntity)) return false;
        ScheduleEntity that = (ScheduleEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ScheduleEntity{" +
                "id=" + id +
                ", schoolId=" + schoolId +
                ", actualFrom=" + actualFrom +
                ", actualTo=" + actualTo +
                ", isExceptional=" + isExceptional +
                '}';
    }
}
