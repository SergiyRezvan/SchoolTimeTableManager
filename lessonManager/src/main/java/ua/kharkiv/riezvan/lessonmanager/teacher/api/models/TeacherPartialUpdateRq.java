package ua.kharkiv.riezvan.lessonmanager.teacher.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherPartialUpdateRq {

    private String lastName;
    private String email;
    private String phone;
    private String password;

}
