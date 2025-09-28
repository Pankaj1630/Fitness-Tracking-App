package com.fitness.activity.Controller;

import com.fitness.activity.Service.ActivityService;
import com.fitness.activity.dto.ActivityRequest;
import com.fitness.activity.dto.ActivityRespose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityRespose> trackActivity(@RequestBody ActivityRequest request)
    {
        return new ResponseEntity<>(activityService.tackAcitivity(request),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ActivityRespose>> getUserActivity(@RequestHeader("X-User-ID") Integer userId)
    {
        return new ResponseEntity<>(activityService.getUserActivity(userId),HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<ActivityRespose> getActivityById(@PathVariable String Id)
    {
        return new ResponseEntity<>(activityService.getActivityById(Id),HttpStatus.OK);
    }
}
