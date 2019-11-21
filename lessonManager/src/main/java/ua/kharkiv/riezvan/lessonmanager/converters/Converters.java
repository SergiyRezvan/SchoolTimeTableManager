package ua.kharkiv.riezvan.lessonmanager.converters;

import ua.kharkiv.riezvan.lessonmanager.classes.api.models.ClassRequest;
import ua.kharkiv.riezvan.lessonmanager.classes.api.models.ClassResponse;
import ua.kharkiv.riezvan.lessonmanager.classes.db.entity.Class;
import ua.kharkiv.riezvan.lessonmanager.teacher.api.models.NewTeacherRequest;
import ua.kharkiv.riezvan.lessonmanager.teacher.api.models.TeacherPartialUpdateRq;
import ua.kharkiv.riezvan.lessonmanager.teacher.api.models.TeacherResponse;
import ua.kharkiv.riezvan.lessonmanager.teacher.db.entity.Teacher;

import java.util.Optional;

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

    public static Teacher convertRqToDbEntity(NewTeacherRequest request) {
        var dbEntity = new Teacher();
        dbEntity.setEmail(request.getEmail());
        dbEntity.setFirstName(request.getFirstName());
        dbEntity.setLastName(request.getLastName());
        dbEntity.setPhone(request.getPhone());
        dbEntity.setUserName(request.getUserName());
        dbEntity.setPassword(request.getPassword());
        return dbEntity;
    }

    public static TeacherResponse convertDbToRs(Teacher dbEntity) {
        return TeacherResponse.builder()
                .id(dbEntity.getId())
                .email(dbEntity.getEmail())
                .lastName(dbEntity.getLastName())
                .firstName(dbEntity.getLastName())
                .phone(dbEntity.getPhone())
                .userName(dbEntity.getUserName())
                .build();
    }

    public static Teacher copyUpdates(Teacher initial, TeacherPartialUpdateRq teacherUpdates) {
        Optional.of(teacherUpdates.getPhone()).ifPresent(initial::setPhone);
        Optional.of(teacherUpdates.getPassword()).ifPresent(initial::setPassword);
        Optional.of(teacherUpdates.getLastName()).ifPresent(initial::setLastName);
        Optional.of(teacherUpdates.getEmail()).ifPresent(initial::setEmail);
        return initial;
    }

}
