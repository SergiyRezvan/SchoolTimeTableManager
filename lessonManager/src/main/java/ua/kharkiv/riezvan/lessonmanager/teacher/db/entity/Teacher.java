package ua.kharkiv.riezvan.lessonmanager.teacher.db.entity;

import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import ua.kharkiv.riezvan.lessonmanager.subject.db.entity.Subject;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "teachers")
@FilterDef(name = "tenantFilter",
        parameters = @ParamDef(
                name = "schoolId",
                type = "long"
        ), defaultCondition = "schoolId = :schoolId")
@Filter(name = "tenantFilter")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachers_seq")
    @SequenceGenerator(name = "teachers_seq", sequenceName = "teachers_seq", allocationSize = 1)
    private Long id;

    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private TeacherRole role;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "teacher_id")
    private List<Subject> subjects;

    @Column(name = "is_deleted")
    private boolean isDeleted;

}
