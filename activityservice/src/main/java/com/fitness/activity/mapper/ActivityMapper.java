package com.fitness.activity.mapper;

import com.fitness.activity.Model.Activity;
import com.fitness.activity.dto.ActivityRespose;
import com.fitness.activity.dto.ActivityRequest;

public class ActivityMapper {
    public static ActivityRespose toResponse(Activity activity) {
        ActivityRespose activityRespose = new ActivityRespose();
        activityRespose.setId(activity.getId());
        activityRespose.setUserId(activity.getUserId());
        activityRespose.setType(activity.getType());
        activityRespose.setDuration(activity.getDuration());
        activityRespose.setCaloriedBured(activity.getCaloriedBured());
        activityRespose.setStartTime(activity.getStartTime());
        activityRespose.setAdditionalMatrix(activity.getAdditionalMatrix());
        activityRespose.setCreatedAt(activity.getCreatedAt());
        activityRespose.setUpdateAt(activity.getUpdateAt());
        return activityRespose;
    }

    public static Activity toEntity(ActivityRequest request) {
        return Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriedBured(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMatrix(request.getAdditionalMatrix())
                .build();
    }
}
