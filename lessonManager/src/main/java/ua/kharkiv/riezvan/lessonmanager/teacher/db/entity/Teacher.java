package ua.kharkiv.riezvan.lessonmanager.teacher.db.entity;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
@FilterDef(name = "tenantFilter",
        parameters = @ParamDef(
                name = "schoolId",
                type = "long"
        ), defaultCondition = "schoolId = :schoolId")
@Filter(name = "tenantFilter")
public class Teacher {




}
