package ua.kharkiv.riezvan.lessonmanager.classes.api.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ClassResponse extends ResourceSupport {

    @EqualsAndHashCode.Include
    private Long classId;
    private String name;

}
