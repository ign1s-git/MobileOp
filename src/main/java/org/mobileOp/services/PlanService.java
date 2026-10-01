package org.mobileOp.services;

import org.mobileOp.Objects.Plan;
import org.mobileOp.enums.PlanType;
import org.mobileOp.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @jakarta.annotation.PostConstruct
    public void initializeDefaultPlans() {
        if (planRepository.count() == 0) {
            planRepository.save(new Plan(PlanType.STANDARD, LocalDateTime.now(), 50, 30));
            planRepository.save(new Plan(PlanType.GOLD, LocalDateTime.now(), 100, 30));
            planRepository.save(new Plan(PlanType.PREMIUM, LocalDateTime.now(), 150, 30));
        }
    }

    public Plan getPlanById(Long id) {
        return planRepository.findById(id).orElse(null);
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public void addPlan(Plan plan) {
        planRepository.save(plan);
    }

    public void removePlan(Plan plan) {
        planRepository.delete(plan);
    }

}
