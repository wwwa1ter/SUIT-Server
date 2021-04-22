package com.pose.dao.plan;

import com.pose.pojo.EverydayCorrection;
import com.pose.pojo.plan.EverydayPlan;

public interface EverydayPlanDao {
    //新增每日计划
    int addEverydayPlan(EverydayPlan plan);

    //删除每日计划
    int deleteEverydayPlan(EverydayPlan plan);

    //获取每日计划
    EverydayPlan queryEverydayPlan(EverydayPlan plan);

    //更改每日动作完成情况
    int updateEverydayPlan(EverydayCorrection correction);
}
