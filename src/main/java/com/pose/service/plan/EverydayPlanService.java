package com.pose.service.plan;

import com.pose.pojo.EverydayCorrection;
import com.pose.pojo.plan.EverydayPlan;

import java.util.List;

public interface EverydayPlanService {

    boolean generateWeekPlan(String reportId);
    EverydayPlan getTodayPlan(String userId);
    boolean updateTodayPlan(EverydayCorrection correction);
}