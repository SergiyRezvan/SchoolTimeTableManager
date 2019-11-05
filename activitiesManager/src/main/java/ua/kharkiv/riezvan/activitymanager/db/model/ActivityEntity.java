package ua.kharkiv.riezvan.activitymanager.db.model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

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

    public ActivityEntity() {}

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

    public LocalTime getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(LocalTime startFrom) {
        this.startFrom = startFrom;
    }

    public LocalTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalTime endAt) {
        this.endAt = endAt;
    }

    public ActivityType getName() {
        return name;
    }

    public void setName(ActivityType name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityEntity that = (ActivityEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ActivityEntity{" +
                "id=" + id +
                ", schoolId=" + schoolId +
                ", startFrom=" + startFrom +
                ", endAt=" + endAt +
                ", name=" + name +
                '}';
    }
}
