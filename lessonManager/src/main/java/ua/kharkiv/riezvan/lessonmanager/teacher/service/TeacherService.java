package ua.kharkiv.riezvan.lessonmanager.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkiv.riezvan.lessonmanager.converters.Converters;
import ua.kharkiv.riezvan.lessonmanager.teacher.api.models.NewTeacherRequest;
import ua.kharkiv.riezvan.lessonmanager.teacher.api.models.TeacherPartialUpdateRq;
import ua.kharkiv.riezvan.lessonmanager.teacher.api.models.TeacherResponse;
import ua.kharkiv.riezvan.lessonmanager.teacher.db.entity.Teacher;
import ua.kharkiv.riezvan.lessonmanager.teacher.db.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherResponse createNewTeacher(NewTeacherRequest request) {
        if (teacherRepository.existsByUserName(request.getUserName())) {
            //TODO: New exception should be introduced.
            throw new IllegalArgumentException("Such user name already in use.");
        }
        var teacherNewEntity = Converters.convertRqToDbEntity(request);
        return Converters.convertDbToRs(teacherRepository.save(teacherNewEntity));
    }

    public TeacherResponse updateTeacher(TeacherPartialUpdateRq request, Long teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        Teacher teacher = optionalTeacher.orElseThrow(() -> new NoSuchElementException("Such teacher does not exists"));
        var updatedTeacher = Converters.copyUpdates(teacher, request);
        return Converters.convertDbToRs(teacherRepository.save(updatedTeacher));
    }

    public TeacherResponse getTeacher(Long teacherId) {
        if (!teacherRepository.existsById(teacherId)) {
            //TODO: New exception should be introduced
            throw new NoSuchElementException("Such teacher does not exists");
        }
        return Converters.convertDbToRs(teacherRepository.findById(teacherId).get());
    }

    public List<TeacherResponse> getAllTeachers() {
        var teacherRs = new ArrayList<TeacherResponse>();
        Iterable<Teacher> teachers = teacherRepository.findAll();
        teachers.forEach(teacher -> teacherRs.add(Converters.convertDbToRs(teacher)));
        return teacherRs;
    }

    public void deleteTeacher(Long teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        Teacher teacher = optionalTeacher.orElseThrow(() -> new NoSuchElementException("Such teacher does not exists"));
        teacher.setDeleted(true);
        teacherRepository.save(teacher);
    }

}
