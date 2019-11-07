package ua.kharkiv.riezvan.lessonmanager.classes.api.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.lessonmanager.classes.services.ClassService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/{schoolName}/classManager")
public class ClassManagerController {

    @Autowired
    private ClassService classService;

    @GetMapping("/")
    public HttpEntity<List<ClassResponse>> getAllClasses() {
        var classResponses = classService.getAllClasses();
        classResponses.forEach(this::addSelfRel);
        return new ResponseEntity<>(classResponses, HttpStatus.OK);
    }

    @PostMapping("/")
    public HttpEntity<ClassResponse> createNewClass(@RequestBody @Valid ClassRequest request) {
        ClassResponse classResponse = classService.createNew(request);
        addSelfRel(classResponse);
        return new ResponseEntity<>(classResponse, HttpStatus.CREATED);
    }

    @PatchMapping("/{classId}")
    public HttpEntity<ClassResponse> updateClass(@RequestBody @Valid ClassRequest request,
                                                 @PathVariable("classId") Long classId) {
        var classResponse = classService.updateClass(request, classId);
        addSelfRel(classResponse);
        return new ResponseEntity<>(classResponse, HttpStatus.OK);
    }

    @GetMapping("/{classId}")
    public HttpEntity<ClassResponse> getClass(@PathVariable("classId") Long classId) {
        var classResponse = classService.getClass(classId);
        addSelfRel(classResponse);
        return new ResponseEntity<>(classResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{classId}")
    public HttpEntity<ClassResponse> deleteClass(@PathVariable("classId") Long classId) {
        classService.deleteClass(classId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private void addSelfRel(ClassResponse response) {
        ControllerLinkBuilder
                .linkTo(methodOn(ClassManagerController.class)
                        .getClass(response.getClassId())).withSelfRel();
    }

}
