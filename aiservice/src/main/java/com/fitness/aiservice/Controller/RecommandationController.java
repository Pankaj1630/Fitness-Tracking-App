package com.fitness.aiservice.Controller;

import com.fitness.aiservice.Model.Recommendation;
import com.fitness.aiservice.Service.RecommandationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommandation")
@RequiredArgsConstructor
public class RecommandationController {

    private final RecommandationService recommandationService;

    @GetMapping("/user/{userID}")
    public ResponseEntity<List<Recommendation>> getUserRecommandation(@PathVariable Integer userID)
    {
        return new ResponseEntity<>(recommandationService.getUserRecommandation(userID), HttpStatus.OK);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<Recommendation> getActivityRecommandation(@PathVariable String activityId)
    {
        return new ResponseEntity<>(recommandationService.getActivityRecommandation(activityId), HttpStatus.OK);
    }
}
