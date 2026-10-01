package mobileOp;

import mobileOp.Enums.PlanType;

import java.util.ArrayList;
import java.util.List;

public class PlanService {
    private List<Plan> plans = new ArrayList<>();

    public PlanService(){
        this.plans.add(new Plan(PlanType.STANDARD,null,50,30));
        this.plans.add(new Plan(PlanType.GOLD,null,100,30));
        this.plans.add(new Plan(PlanType.PREMIUM,null,150,30));
    };

    public Plan getPlanById(int id){
        return this.plans.get(id);
    }
}
