package com.activityService.service;

import com.activityService.dto.ActivityRequest;
import com.activityService.dto.ActivityResponse;
import com.activityService.models.Activity;
import com.activityService.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity=Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .caloriesBurned(request.getCaloriesBurned())
                .duration(request.getDuration())
                .additionalMetrics(request.getAdditionalMetrics())
                .startTime(request.getStartTime())
                .build();

        Activity savedActivity=activityRepository.save(activity);
        return mapToRes(savedActivity);
    }
    private ActivityResponse mapToRes(Activity activity){
        ActivityResponse res=new ActivityResponse();
        res.setId(activity.getId());
        res.setType(activity.getType());
        res.setDuration(activity.getDuration());
        res.setCaloriesBurned(activity.getCaloriesBurned());
        res.setAdditionalMetrics(activity.getAdditionalMetrics());
        res.setUpdatedAt(activity.getUpdatedAt());
        res.setStartTime(activity.getStartTime());
        res.setCreatedAt(activity.getCreatedAt());
        res.setUserId(activity.getUserId());
        return res;
    }
    public List<ActivityResponse> getUserActivities(String userId) {
        List <Activity> activities=activityRepository.findByUserId(userId);
        return activities.stream()
                .map(this::mapToRes)
                .collect(Collectors.toList());
    }

    public ActivityResponse getActivityById(String activityId) {
        return activityRepository.findById(activityId)
                .map(this::mapToRes)
                .orElseThrow(() -> new RuntimeException("Activity not found" + activityId));
    }
}
