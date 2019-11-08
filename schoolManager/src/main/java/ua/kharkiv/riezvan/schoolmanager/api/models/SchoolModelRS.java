package ua.kharkiv.riezvan.schoolmanager.api.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
public class SchoolModelRS {

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
