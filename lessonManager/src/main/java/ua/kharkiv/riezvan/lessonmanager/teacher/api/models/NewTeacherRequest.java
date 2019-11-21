package ua.kharkiv.riezvan.lessonmanager.teacher.api.models;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class NewTeacherRequest {

    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;


}
