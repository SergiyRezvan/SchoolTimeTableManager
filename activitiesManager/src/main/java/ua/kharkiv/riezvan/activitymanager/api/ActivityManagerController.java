package ua.kharkiv.riezvan.activitymanager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.activitymanager.api.model.ActivityManagerRq;
import ua.kharkiv.riezvan.activitymanager.api.model.ActivityManagerRs;
import ua.kharkiv.riezvan.activitymanager.service.ActivityManagerService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/{schoolName}/activityManager")
public class ActivityManagerController {

    @Autowired
    private ActivityManagerService activityManagerService;

    @GetMapping
    public HttpEntity<List<ActivityManagerRs>> getAll() {
        List<ActivityManagerRs> activities = activityManagerService.getActivities();
        activities.forEach(this::addSelfRel);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/{activityId}")
    public HttpEntity<ActivityManagerRs> getActivity(@PathVariable("activityId") Long activityId) {
        ActivityManagerRs activity = activityManagerService.getActivityById(activityId);
        addSelfRel(activity);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<ActivityManagerRs> saveActivity(@RequestBody @Valid ActivityManagerRq activityManagerRq) {
        ActivityManagerRs activityManagerRs = activityManagerService.saveActivity(activityManagerRq);
        addSelfRel(activityManagerRs);
        return new ResponseEntity<>(activityManagerRs, HttpStatus.CREATED);
    }

    @PatchMapping("/{activityId}")
    public HttpEntity<ActivityManagerRs> updateActivity(@RequestBody @Valid ActivityManagerRq activityManagerRq,
                                                        @PathVariable("activityId") Long activityId) {
        ActivityManagerRs activityManagerRs = activityManagerService.updateActivity(activityManagerRq, activityId);
        addSelfRel(activityManagerRs);
        return new ResponseEntity<>(activityManagerRs, HttpStatus.OK);
    }

    @DeleteMapping("/{activityId}")
    public HttpEntity deleteActivity(@PathVariable("activityId") Long activityId) {
        activityManagerService.delete(activityId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private void addSelfRel(ActivityManagerRs activityManagerRs) {
        ControllerLinkBuilder
                .linkTo(methodOn(ActivityManagerController.class)
                        .getActivity(activityManagerRs.getActivityId())).withSelfRel();
    }

}
