package ua.kharkiv.riezvan.schoolmanager.api.models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SchoolModelRQ {

    private Long id;

    @NotBlank(message = "Please provide school name")
    private String name;

    private String description;

    @NotBlank(message = "Please provide school phone number")
    private String phone;

    @NotBlank(message = "Please provide school address")
    private String address;

    @NotBlank(message = "Please provide school email")
    @Email(message = "Please provide email in a valid format")
    private String email;

    @NotBlank(message = "Please provide school director")
    private String director;

    @NotBlank(message = "please provide school website")
    private String webSite;

}
