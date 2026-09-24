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
        this.plans.add(new Plan(PlanType.STANDARD, LocalDateTime.now(),50,30));
        this.plans.add(new Plan(PlanType.GOLD,LocalDateTime.now(),100,30));
        this.plans.add(new Plan(PlanType.PREMIUM,LocalDateTime.now(),150,30));
    }

    public Plan getPlanById(int id){
        return this.plans.get(id);
    }
}
