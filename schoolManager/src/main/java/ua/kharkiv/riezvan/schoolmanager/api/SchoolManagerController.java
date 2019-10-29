package ua.kharkiv.riezvan.schoolmanager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRS;
import ua.kharkiv.riezvan.schoolmanager.service.SchoolManagerService;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/schoolManager")
public class SchoolManagerController {

    @Autowired
    private SchoolManagerService schoolManagerService;

    @PostMapping
    public HttpEntity<SchoolModelRS> createNewSchool(@RequestBody SchoolModelRQ request,
                                                    @RequestHeader(AUTHORIZATION) String header) {
        SchoolModelRS schoolModelRS = schoolManagerService.save(request);
        return new ResponseEntity<>(schoolModelRS, HttpStatus.CREATED);
    }

    @GetMapping
    public HttpEntity<List<SchoolModelRS>> getAllSchools() {
        return null;
    }

    @GetMapping("/{schoolId}")
    public HttpEntity<SchoolModelRS> getSchool(@PathVariable("schoolId") String schoolId) {
        return null;
    }

    @PatchMapping
    public HttpEntity<SchoolModelRS> updateSchool(@RequestBody SchoolModelRQ request) {
        return null;
    }

    @DeleteMapping("/{schoolId}")
    public ResponseEntity deleteSchool(@PathVariable("schoolId") String schoolId) {

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
