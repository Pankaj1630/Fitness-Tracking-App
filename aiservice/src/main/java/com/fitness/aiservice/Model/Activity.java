package com.fitness.aiservice.Model;

import lombok.Data;


import java.time.LocalDateTime;
import java.util.Map;


@Data
public class Activity {
    private String id;
    private Integer userId;
    private Integer duration;
    private Integer caloriedBured;
    private String types;
    private LocalDateTime startTime;
    private Map<String,Object> additionalMatrix;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
