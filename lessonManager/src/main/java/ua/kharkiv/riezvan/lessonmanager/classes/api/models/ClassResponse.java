package ua.kharkiv.riezvan.lessonmanager.classes.api.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ClassResponse {

    @EqualsAndHashCode.Include
    private Long classId;
    private String name;

}
