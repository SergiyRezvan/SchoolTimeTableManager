package ua.kharkiv.riezvan.schedulemanager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.schedulemanager.api.models.ScheduleManagerRQ;
import ua.kharkiv.riezvan.schedulemanager.api.models.ScheduleManagerRS;
import ua.kharkiv.riezvan.schedulemanager.service.ScheduleManagerService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/{schoolName}/scheduleManager")
public class ScheduleManagerController {

    @Autowired
    private ScheduleManagerService scheduleManagerService;

    @GetMapping
    public HttpEntity<List<ScheduleManagerRS>> getAllSchedules() {
        List<ScheduleManagerRS> allSchedules = scheduleManagerService.getAllSchedules();
        allSchedules.forEach(this::addSelfRel);
        return new ResponseEntity<>(allSchedules, HttpStatus.OK);
    }

    @GetMapping("/{scheduleId}")
    public HttpEntity<ScheduleManagerRS> getSchedule(@PathVariable("scheduleId") Long scheduleId) {
        ScheduleManagerRS schedule = scheduleManagerService.getSchedule(scheduleId);
        addSelfRel(schedule);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<ScheduleManagerRS> createSchedule(@RequestBody @Valid ScheduleManagerRQ request) {
        var schedule = scheduleManagerService.saveSchedule(request);
        addSelfRel(schedule);
        return new ResponseEntity<>(schedule, HttpStatus.CREATED);
    }

    @PatchMapping("/{scheduleId}")
    public HttpEntity<ScheduleManagerRS> updateSchedule(@RequestBody @Valid ScheduleManagerRQ request,
                                                        @PathVariable("scheduleId") Long scheduleId) {
        var updatedSchedule = scheduleManagerService.updateSchedule(request, scheduleId);
        addSelfRel(updatedSchedule);
        return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
    }

    @DeleteMapping("/{scheduleId}")
    public HttpEntity deleteSchedule(@PathVariable("scheduleId") Long scheduleId) {
        scheduleManagerService.deleteSchedule(scheduleId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private void addSelfRel(ScheduleManagerRS schoolResponse) {
        ControllerLinkBuilder
                .linkTo(methodOn(ScheduleManagerController.class)
                        .getSchedule(schoolResponse.getScheduleId())).withSelfRel();
    }

}
