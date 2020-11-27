package ua.kharkiv.riezvan.schoolmanager.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelPartialUpdateRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRS;
import ua.kharkiv.riezvan.schoolmanager.service.SchoolManagerService;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
public class SchoolManagerController {

    private final SchoolManagerService schoolManagerService;

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

    @GetMapping("/schoolManager/{restName}")
    public HttpEntity<SchoolModelRS> getSchool(@PathVariable("restName") String restName) {
        SchoolModelRS schoolResponse = schoolManagerService.getSchool(restName);
        return new ResponseEntity<>(schoolResponse, HttpStatus.OK);
    }

    @PatchMapping("/schoolManager/{restName}")
    public HttpEntity<SchoolModelRS> updateSchool(@RequestBody SchoolModelPartialUpdateRQ request, @PathVariable("restName") String restName ) {
        SchoolModelRS schoolResponse = schoolManagerService.update(request, restName);
        return new ResponseEntity<>(schoolResponse, HttpStatus.OK);
    }

    @DeleteMapping("/schoolManager/{restName}")
    public ResponseEntity deleteSchool(@PathVariable("restName") String restName) {
        schoolManagerService.delete(restName);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
