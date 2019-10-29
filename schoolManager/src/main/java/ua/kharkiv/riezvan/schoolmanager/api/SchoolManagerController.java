package ua.kharkiv.riezvan.schoolmanager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRS;
import ua.kharkiv.riezvan.schoolmanager.service.SchoolManagerService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/schoolManager")
public class SchoolManagerController {

    @Autowired
    private SchoolManagerService schoolManagerService;

    @PostMapping
    public HttpEntity<SchoolModelRS> createNewSchool(@RequestBody @Valid SchoolModelRQ request) {
        SchoolModelRS schoolModelRS = schoolManagerService.save(request);
        ControllerLinkBuilder
                .linkTo(methodOn(SchoolManagerController.class)
                        .getSchool(schoolModelRS.getId())).withSelfRel();
        return new ResponseEntity<>(schoolModelRS, HttpStatus.CREATED);
    }

    @GetMapping
    public HttpEntity<List<SchoolModelRS>> getAllSchools() {
        return null;
    }

    @GetMapping("/{schoolId}")
    public HttpEntity<SchoolModelRS> getSchool(@PathVariable("schoolId") Long schoolId) {
        return null;
    }

    @PatchMapping
    public HttpEntity<SchoolModelRS> updateSchool(@RequestBody SchoolModelRQ request) {
        return null;
    }

    @DeleteMapping("/{schoolId}")
    public ResponseEntity deleteSchool(@PathVariable("schoolId") Long schoolId) {

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
