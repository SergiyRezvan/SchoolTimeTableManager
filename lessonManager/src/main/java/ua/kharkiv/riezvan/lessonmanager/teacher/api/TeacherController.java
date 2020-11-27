package ua.kharkiv.riezvan.lessonmanager.teacher.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.lessonmanager.teacher.api.models.NewTeacherRequest;
import ua.kharkiv.riezvan.lessonmanager.teacher.api.models.TeacherPartialUpdateRq;
import ua.kharkiv.riezvan.lessonmanager.teacher.api.models.TeacherResponse;
import ua.kharkiv.riezvan.lessonmanager.teacher.service.TeacherService;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/{schoolName}/teacherManager")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public HttpEntity<List<TeacherResponse>> getAllTeachers() {
        List<TeacherResponse> allTeachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(allTeachers, HttpStatus.OK);
    }

    @GetMapping("/{teacherId}")
    public HttpEntity<TeacherResponse> getTeacher(@PathVariable("teacherId") Long teacherId) {
        TeacherResponse teacher = teacherService.getTeacher(teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<TeacherResponse> createNewTeacher(@RequestBody @Valid NewTeacherRequest request) {
        var teacher = teacherService.createNewTeacher(request);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @PatchMapping("/{teacherId}")
    public HttpEntity<TeacherResponse> updateTeacher(@RequestBody @Valid TeacherPartialUpdateRq request,
                                                     @PathVariable("teacherId") Long teacherId) {
        var teacher = teacherService.updateTeacher(request, teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @DeleteMapping("/{teacherId}")
    public HttpEntity deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
