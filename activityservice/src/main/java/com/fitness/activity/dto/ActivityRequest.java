package com.fitness.activity.dto;

import com.fitness.activity.Model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
@Data
public class ActivityRequest {
    private Integer userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String,Object> additionalMatrix;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
