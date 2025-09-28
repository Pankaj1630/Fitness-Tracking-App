package com.fitness.aiservice.Service;

import com.fitness.aiservice.Model.Activity;
import com.fitness.aiservice.Model.Recommendation;
import com.fitness.aiservice.Repository.RecommandationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityListner {

    private final ActivityAiService activityAiService;
    private final RecommandationRepository recommandationRepository;

    @RabbitListener(queues = "activity.queue")
    public void processActivity(Activity activity)
    {
        log.info("Received activity for processing: "+ activity.getId());
//        log.info("Generated recommandation: "+ activityAiService.generateRecommandation(activity));
        Recommendation generatedRecommandation = activityAiService.generateRecommandation(activity);
        recommandationRepository.save(generatedRecommandation);

    }

}
