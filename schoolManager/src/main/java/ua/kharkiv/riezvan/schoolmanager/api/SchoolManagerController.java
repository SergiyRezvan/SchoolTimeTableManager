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

@RestController
@RequestMapping
public class SchoolManagerController {

    @Autowired
    private SchoolManagerService schoolManagerService;

    @PostMapping("/schoolManager")
    public HttpEntity<SchoolModelRS> createNewSchool(@RequestBody @Valid SchoolModelRQ request) {
        SchoolModelRS schoolResponse = schoolManagerService.save(request);
        addSelfRel(schoolResponse);
        return new ResponseEntity<>(schoolResponse, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public HttpEntity<List<SchoolModelRS>> getAllSchools() {
        List<SchoolModelRS> allSchools = schoolManagerService.getAllSchools();
        allSchools.forEach(schoolResponse -> ControllerLinkBuilder
                .linkTo(methodOn(SchoolManagerController.class)
                        .getSchool(schoolResponse.getSchoolId())).withSelfRel());
        return new ResponseEntity<>(allSchools, HttpStatus.OK);
    }

    @GetMapping("/schoolManager/{schoolId}")
    public HttpEntity<SchoolModelRS> getSchool(@PathVariable("schoolId") Long schoolId) {
        SchoolModelRS schoolResponse = schoolManagerService.getSchool(schoolId);
        addSelfRel(schoolResponse);
        return null;
    }

    @PatchMapping("/schoolManager/{schoolId}")
    public HttpEntity<SchoolModelRS> updateSchool(@RequestBody SchoolModelRQ request, @PathVariable("schoolId") Long schoolId ) {
        SchoolModelRS schoolResponse = schoolManagerService.update(request, schoolId);
        addSelfRel(schoolResponse);
        return new ResponseEntity<>(schoolResponse, HttpStatus.OK);
    }

    private void addSelfRel(SchoolModelRS schoolResponse) {
        ControllerLinkBuilder
                .linkTo(methodOn(SchoolManagerController.class)
                        .getSchool(schoolResponse.getSchoolId())).withSelfRel();
    }

    @DeleteMapping("/schoolManager/{schoolId}")
    public ResponseEntity deleteSchool(@PathVariable("schoolId") Long schoolId) {
        schoolManagerService.delete(schoolId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
