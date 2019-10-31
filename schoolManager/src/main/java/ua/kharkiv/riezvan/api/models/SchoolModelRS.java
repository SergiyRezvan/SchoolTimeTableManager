package ua.kharkiv.riezvan.api.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
public class SchoolModelRS extends ResourceSupport {

    @EqualsAndHashCode.Include
    private Long schoolId;

    private String name;

    private String description;

    private String phone;

    private String address;

    private String email;

    private String director;

    private String webSite;

}
