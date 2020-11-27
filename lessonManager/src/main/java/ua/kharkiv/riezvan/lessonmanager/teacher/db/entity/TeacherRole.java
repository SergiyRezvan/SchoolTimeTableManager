package ua.kharkiv.riezvan.lessonmanager.teacher.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teacher_roles")
public class TeacherRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_roles_seq")
    @SequenceGenerator(name = "teacher_roles_seq", sequenceName = "teacher_roles_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

}
