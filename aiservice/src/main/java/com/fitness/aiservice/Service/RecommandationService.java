package com.fitness.aiservice.Service;

import com.fitness.aiservice.Model.Recommendation;
import com.fitness.aiservice.Repository.RecommandationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommandationService {
    private final RecommandationRepository recommandationRepository;

    public List<Recommendation> getUserRecommandation(Integer userID) {
        List<Recommendation> recommendations = recommandationRepository.findByUserId(userID);
        if (recommendations == null || recommendations.isEmpty()) {
            throw new RuntimeException("No recommendations found for userID: " + userID);
        }
        return recommendations;    }

    public Recommendation getActivityRecommandation(String activityId) {
        Recommendation recommendation = recommandationRepository.findByActivityId(activityId);
        if (recommendation == null) {
            throw new RuntimeException("No recommendation found for activityId: " + activityId);
        }
        return recommendation;    }
}
