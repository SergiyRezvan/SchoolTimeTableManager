package ua.kharkiv.riezvan.lessonmanager.classes.db.entity;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import ua.kharkiv.riezvan.lessonmanager.subject.db.entity.Subject;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    private Long id;

    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "class_id")
    private List<Subject> subjectList;

    public Class() {}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void addSubject(Subject subject) {
        subjectList.add(subject);
    }

    public void deleteSubject(Subject subject) {
        subjectList.remove(subject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class)) return false;
        Class aClass = (Class) o;
        return id.equals(aClass.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", schoolId=" + schoolId +
                ", name='" + name + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
