package ua.kharkiv.riezvan.schoolmanager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRS;
import ua.kharkiv.riezvan.schoolmanager.service.SchoolManagerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class SchoolManagerController {

    @Autowired
    private SchoolManagerService schoolManagerService;

    @PostMapping("/schoolManager")
    public HttpEntity<SchoolModelRS> createNewSchool(@RequestBody @Valid SchoolModelRQ request) {
        SchoolModelRS schoolResponse = schoolManagerService.save(request);
        return new ResponseEntity<>(schoolResponse, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public HttpEntity<List<SchoolModelRS>> getAllSchools() {
        List<SchoolModelRS> allSchools = schoolManagerService.getAllSchools();
        return new ResponseEntity<>(allSchools, HttpStatus.OK);
    }

    @GetMapping("/schoolManager/{schoolId}")
    public HttpEntity<SchoolModelRS> getSchool(@PathVariable("schoolId") Long schoolId) {
        SchoolModelRS schoolResponse = schoolManagerService.getSchool(schoolId);
        return null;
    }

    @PatchMapping("/schoolManager/{schoolId}")
    public HttpEntity<SchoolModelRS> updateSchool(@RequestBody SchoolModelRQ request, @PathVariable("schoolId") Long schoolId ) {
        SchoolModelRS schoolResponse = schoolManagerService.update(request, schoolId);
        return new ResponseEntity<>(schoolResponse, HttpStatus.OK);
    }

    @DeleteMapping("/schoolManager/{schoolId}")
    public ResponseEntity deleteSchool(@PathVariable("schoolId") Long schoolId) {
        schoolManagerService.delete(schoolId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
