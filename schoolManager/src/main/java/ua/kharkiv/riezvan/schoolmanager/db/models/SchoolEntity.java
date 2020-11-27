package ua.kharkiv.riezvan.schoolmanager.db.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "schools")
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schools_seq")
    @SequenceGenerator(name = "schools_seq", sequenceName = "schools_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @EqualsAndHashCode.Include
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

}
