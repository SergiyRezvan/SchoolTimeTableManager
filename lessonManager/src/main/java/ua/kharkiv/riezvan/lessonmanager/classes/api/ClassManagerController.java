package ua.kharkiv.riezvan.lessonmanager.classes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.lessonmanager.classes.api.models.ClassRequest;
import ua.kharkiv.riezvan.lessonmanager.classes.api.models.ClassResponse;
import ua.kharkiv.riezvan.lessonmanager.classes.services.ClassService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/{schoolName}/classManager")
public class ClassManagerController {

    @Autowired
    private ClassService classService;

    @GetMapping("/")
    public HttpEntity<List<ClassResponse>> getAllClasses() {
        var classResponses = classService.getAllClasses();
        return new ResponseEntity<>(classResponses, HttpStatus.OK);
    }

    @PostMapping("/")
    public HttpEntity<ClassResponse> createNewClass(@RequestBody @Valid ClassRequest request) {
        ClassResponse classResponse = classService.createNew(request);
        return new ResponseEntity<>(classResponse, HttpStatus.CREATED);
    }

    @PatchMapping("/{classId}")
    public HttpEntity<ClassResponse> updateClass(@RequestBody @Valid ClassRequest request,
                                                 @PathVariable("classId") Long classId) {
        var classResponse = classService.updateClass(request, classId);
        return new ResponseEntity<>(classResponse, HttpStatus.OK);
    }

    @GetMapping("/{classId}")
    public HttpEntity<ClassResponse> getClass(@PathVariable("classId") Long classId) {
        var classResponse = classService.getClass(classId);
        return new ResponseEntity<>(classResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{classId}")
    public HttpEntity<ClassResponse> deleteClass(@PathVariable("classId") Long classId) {
        classService.deleteClass(classId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
