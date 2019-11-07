package ua.kharkiv.riezvan.lessonmanager.converters;

import ua.kharkiv.riezvan.lessonmanager.classes.api.models.ClassRequest;
import ua.kharkiv.riezvan.lessonmanager.classes.api.models.ClassResponse;
import ua.kharkiv.riezvan.lessonmanager.classes.db.entity.Class;

public final class Converters {

    private Converters() {}

    public static ClassResponse convertDbToRS(Class entity) {
        return ClassResponse.builder()
                .classId(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Class convertRqToDbEntity(ClassRequest request) {
        var dbEntity = new Class();
        dbEntity.setId(request.getId());
        dbEntity.setName(request.getName());
        return dbEntity;
    }
}
