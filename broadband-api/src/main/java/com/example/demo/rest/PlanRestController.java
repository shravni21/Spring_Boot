package com.example.demo.rest;

import com.example.demo.entity.Plan;
import com.example.demo.service.service_interface.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanRestController {
    private final PlanService planService;

    @Autowired
    public PlanRestController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/plans")
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }

    @GetMapping("/plans/{id}")
    public Plan getPlanById(@PathVariable int id) {
        Plan plan = planService.getPlanById(id);
        if (plan == null) {
            throw new RuntimeException("Plan not found with id: " + id);
        }
        return plan;
    }

    @PostMapping("/plans")
    public Plan savePlan(@RequestBody Plan plan) {
//        plan.setId(0);
        return planService.savePlan(plan);
    }

    @PutMapping("/plans/{id}")
    public Plan updatePlan(@PathVariable int id, @RequestBody Plan updatedPlan) {
        Plan existingPlan = planService.getPlanById(id);
        if (existingPlan == null) {
            throw new RuntimeException("Plan not found with id: " + id);
        }

        // Update the existing plan object with the new values
        existingPlan.setName(updatedPlan.getName());
        existingPlan.setDuration(updatedPlan.getDuration());
        existingPlan.setAmount(updatedPlan.getAmount());

        // Save the updated plan object
        return planService.savePlan(existingPlan);
    }


    @DeleteMapping("/plans/{id}")
    public String deletePlan(@PathVariable int id) {
        Plan plan = planService.getPlanById(id);
        if (plan == null) {
            throw new RuntimeException("Plan not found with id: " + id);
        }
        planService.deletePlan(id);
        return "Deleted plan with id: " + id;
    }
}
