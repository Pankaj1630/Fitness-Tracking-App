package com.fitness.activity.Repository;

import com.fitness.activity.Model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity,String> {
    List<Activity> findByUserId(Integer userId);
}
