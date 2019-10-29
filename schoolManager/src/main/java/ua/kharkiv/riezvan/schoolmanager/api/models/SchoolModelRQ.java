package ua.kharkiv.riezvan.schoolmanager.api.models;

import lombok.Data;

@Data
public class SchoolModelRQ {

    private Long id;

    private String name;

    private String description;

    private String phone;

    private String address;

    private String email;

    private String director;

    private String webSite;

}
