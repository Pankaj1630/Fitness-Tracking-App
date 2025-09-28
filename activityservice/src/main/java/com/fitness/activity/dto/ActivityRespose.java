package com.fitness.activity.dto;

import com.fitness.activity.Model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityRespose {
    private String Id;
    private Integer UserId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriedBured;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMatrix;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
