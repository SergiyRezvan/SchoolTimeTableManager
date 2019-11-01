package ua.kharkiv.riezvan.schoolmanager.converters;

import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRS;
import ua.kharkiv.riezvan.schoolmanager.db.models.SchoolEntity;

public class Converters {

    public static SchoolEntity convertRequestToDbEntity(SchoolModelRQ request) {
        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setAddress(request.getAddress());
        schoolEntity.setDescription(request.getDescription());
        schoolEntity.setDirector(request.getDirector());
        schoolEntity.setEmail(request.getEmail());
        schoolEntity.setName(request.getName());
        schoolEntity.setPhone(request.getPhone());
        schoolEntity.setWebSite(request.getWebSite());
        return schoolEntity;
    }

    public static SchoolModelRS convertEntityToRs(SchoolEntity schoolEntity) {
        return SchoolModelRS.builder()
                .schoolId(schoolEntity.getId())
                .address(schoolEntity.getAddress())
                .description(schoolEntity.getDescription())
                .director(schoolEntity.getDirector())
                .email(schoolEntity.getEmail())
                .name(schoolEntity.getName())
                .phone(schoolEntity.getPhone())
                .webSite(schoolEntity.getWebSite())
                .build();
    }

}
