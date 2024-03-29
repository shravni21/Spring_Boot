package com.example.demo.service;

import com.example.demo.entity.Plan;

import java.util.List;

public interface PlanService {
    List<Plan> getAllPlans();

    Plan getPlanById(int id);

    Plan savePlan(Plan plan);

    void deletePlan(int id);
}
