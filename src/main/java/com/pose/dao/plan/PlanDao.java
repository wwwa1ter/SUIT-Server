package com.pose.dao.plan;

import com.pose.pojo.plan.Plan;

public interface PlanDao {
    //新增计划
    int addPlan(Plan plan);

    //删除计划
    int deletePlanById(String reportId);

    //获取计划
    Plan queryPlanById(String reportId);

    //修改计划
    int updatePlan(Plan plan);
}
