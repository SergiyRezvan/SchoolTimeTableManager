package ua.kharkiv.riezvan.activitymanager.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharkiv.riezvan.activitymanager.api.model.ActivityManagerRq;
import ua.kharkiv.riezvan.activitymanager.api.model.ActivityManagerRs;
import ua.kharkiv.riezvan.activitymanager.service.ActivityManagerService;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/{schoolName}/activityManager")
public class ActivityManagerController {

    private final ActivityManagerService activityManagerService;

    @GetMapping
    public HttpEntity<List<ActivityManagerRs>> getAll() {
        List<ActivityManagerRs> activities = activityManagerService.getActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/{activityId}")
    public HttpEntity<ActivityManagerRs> getActivity(@PathVariable("activityId") Long activityId) {
        ActivityManagerRs activity = activityManagerService.getActivityById(activityId);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<ActivityManagerRs> saveActivity(@RequestBody @Valid ActivityManagerRq activityManagerRq) {
        ActivityManagerRs activityManagerRs = activityManagerService.saveActivity(activityManagerRq);
        return new ResponseEntity<>(activityManagerRs, HttpStatus.CREATED);
    }

    @PatchMapping("/{activityId}")
    public HttpEntity<ActivityManagerRs> updateActivity(@RequestBody @Valid ActivityManagerRq activityManagerRq,
                                                        @PathVariable("activityId") Long activityId) {
        ActivityManagerRs activityManagerRs = activityManagerService.updateActivity(activityManagerRq, activityId);
        return new ResponseEntity<>(activityManagerRs, HttpStatus.OK);
    }

    @DeleteMapping("/{activityId}")
    public HttpEntity deleteActivity(@PathVariable("activityId") Long activityId) {
        activityManagerService.delete(activityId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
