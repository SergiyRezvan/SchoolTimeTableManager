package ua.kharkiv.riezvan.lessonmanager.classes.db.entity;

import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import ua.kharkiv.riezvan.lessonmanager.subject.db.entity.Subject;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "classes")
@FilterDef(name = "tenantFilter",
        parameters = @ParamDef(
                name = "schoolId",
                type = "long"
        ), defaultCondition = "schoolId = :schoolId")
@Filter(name = "tenantFilter")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classes_seq")
    @SequenceGenerator(name = "classes_seq", sequenceName = "classes_seq", allocationSize = 1)
    private Long id;

    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "class_id")
    private List<Subject> subjectList;

    public void addSubject(Subject subject) {
        subjectList.add(subject);
    }

    public void deleteSubject(Subject subject) {
        subjectList.remove(subject);
    }

}
