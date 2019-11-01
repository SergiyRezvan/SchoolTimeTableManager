package ua.kharkiv.riezvan.lessonmanager.subject.db.entity;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import ua.kharkiv.riezvan.lessonmanager.classes.db.entity.Class;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@FilterDef(name = "tenantFilter",
        parameters = @ParamDef(
                name = "schoolId",
                type = "long"
        ), defaultCondition = "schoolId = :schoolId")
@Filter(name = "tenantFilter")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subjects_seq")
    private Long id;

    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "hours_per_week")
    private Integer hoursPerWeek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Class schoolClass;

}
