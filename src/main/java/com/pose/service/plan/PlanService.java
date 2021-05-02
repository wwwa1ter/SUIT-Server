package com.pose.service.plan;

import com.pose.pojo.plan.Plan;

public interface PlanService {
    //添加新的计划
    boolean addPlan(Plan plan);
    //查询计划
    Plan queryPlan(String reportId);
}
