package ua.kharkiv.riezvan.lessonmanager.classes.api.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ClassRequest {

    private Long id;
    @NotBlank
    private String name;

}
