package org.mobileOp.controllers;

import org.mobileOp.Objects.Plan;
import org.mobileOp.Objects.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping
    public List<Plan> getAllPlans(){
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable("id") Long id){
        return planService.getPlanById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable("id") Long id){
        planService.removePlan(planService.getPlanById(id));
    }

    @PostMapping
    public Plan createPlan(@RequestBody Plan plan){
        planService.addPlan(plan);
        return plan;
    }
}
