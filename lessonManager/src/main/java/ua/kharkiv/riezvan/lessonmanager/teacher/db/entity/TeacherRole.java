package ua.kharkiv.riezvan.lessonmanager.teacher.db.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher_roles")
public class TeacherRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_roles_seq")
    @SequenceGenerator(name = "teacher_roles_seq", sequenceName = "teacher_roles_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    public TeacherRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherRole)) return false;
        TeacherRole that = (TeacherRole) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TeacherRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
