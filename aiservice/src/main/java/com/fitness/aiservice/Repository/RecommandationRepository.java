package com.fitness.aiservice.Repository;

import com.fitness.aiservice.Model.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommandationRepository extends MongoRepository<Recommendation, String> {
    List<Recommendation> findByUserId(Integer userID);

    Recommendation findByActivityId(String activityId);
}
