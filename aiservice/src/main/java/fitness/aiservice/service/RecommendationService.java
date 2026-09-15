package fitness.aiservice.service;

import fitness.aiservice.model.Recommendations;
import fitness.aiservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;

    public Recommendations getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId)
                .orElseThrow(()-> new RuntimeException("No Recommendations found for this activity"));
    }

    public List<Recommendations> getUserRecommendation(String userId) {
       return recommendationRepository.findByUserId(userId);
    }
}
