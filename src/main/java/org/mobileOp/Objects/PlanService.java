package org.mobileOp.Objects;

import lombok.AllArgsConstructor;
import org.mobileOp.enums.PlanType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PlanService {
    private List<Plan> plans = new ArrayList<>();

    public PlanService(){
        this.plans.add(new Plan((long) 1,PlanType.STANDARD, LocalDateTime.now(),50,30));
        this.plans.add(new Plan((long)this.plans.size()+1,PlanType.GOLD,LocalDateTime.now(),100,30));
        this.plans.add(new Plan((long)this.plans.size()+1,PlanType.PREMIUM,LocalDateTime.now(),150,30));
    }
    public Plan getPlanById(Long id){
        for (Plan p : this.plans) {
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    public List<Plan> getAllPlans(){
        return this.plans;
    }
    public void addPlan(Plan plan){
        plan.setId((long) this.plans.size() + 1);
        this.plans.add(plan);
    }
    public void removePlan(Plan plan){
        this.plans.remove(plan);
    }

}
