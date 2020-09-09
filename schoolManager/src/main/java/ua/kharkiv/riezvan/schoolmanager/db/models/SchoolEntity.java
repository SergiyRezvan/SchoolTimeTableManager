package ua.kharkiv.riezvan.schoolmanager.db.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "schools")
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schools_seq")
    @SequenceGenerator(name = "schools_seq", sequenceName = "schools_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "rest_resource_name", length = 100)
    private String restName;

    @Column(name = "description")
    private String description;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "director", length = 100)
    private String director;

    @Column(name = "school_website", length = 150)
    private String schoolWebsite;

    public SchoolEntity() {
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

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSchoolWebsite() {
        return schoolWebsite;
    }

    public void setSchoolWebsite(String schoolWebsite) {
        this.schoolWebsite = schoolWebsite;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolEntity that = (SchoolEntity) o;
        return restName.equals(that.restName);
    }

    public int hashCode() {
        return Objects.hash(restName);
    }
}
