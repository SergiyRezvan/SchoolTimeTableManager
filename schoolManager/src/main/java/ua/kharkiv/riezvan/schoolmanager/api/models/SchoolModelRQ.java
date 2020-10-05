package ua.kharkiv.riezvan.schoolmanager.api.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class SchoolModelRQ {

    private Long id;

    @NotBlank(message = "Please provide school name")
    private String name;

    @NotBlank(message = "Please provide url school name")
    @Pattern(regexp = "[a-zA-Z0-9]{3,20}", message = "URL name should contain only latin letters and numbers")
    private String restName;

    @Length(max = 500, message = "Please use not more than 500 symbols")
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
