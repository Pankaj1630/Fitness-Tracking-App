package com.fitness.activity.Service;

import com.fitness.activity.Model.Activity;
import com.fitness.activity.Repository.ActivityRepository;
import com.fitness.activity.dto.ActivityRequest;
import com.fitness.activity.dto.ActivityRespose;
import com.fitness.activity.mapper.ActivityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserServiceValidation userServiceValidation;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchanger;
    @Value("${rabbitmq.routing.name}")
    private String routingKey;


    public ActivityRespose tackAcitivity(ActivityRequest request) {
        boolean validateUser = userServiceValidation.validate(request.getUserId());
        if(!validateUser)
        {
            throw new RuntimeException("Invalid user");
        }
        Activity activity = ActivityMapper.toEntity(request);
        Activity save = activityRepository.save(activity);

        //publish for ai processing
        try{
            rabbitTemplate.convertAndSend(exchanger,routingKey,save);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to publish activity");
        }
        return ActivityMapper.toResponse(save);
    }

    public ActivityRespose getActivityById(String Id) {
    return activityRepository.findById(Id)
        .map(ActivityMapper::toResponse)
        .orElseThrow(() -> new RuntimeException("Activity not found for ID: " + Id));
    }

    public List<ActivityRespose> getUserActivity(Integer userId) {
    List<Activity> activities = activityRepository.findByUserId(userId);
    return activities.stream().map(ActivityMapper::toResponse).toList();
    }

}
