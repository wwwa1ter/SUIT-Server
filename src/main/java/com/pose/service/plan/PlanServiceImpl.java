package com.pose.service.plan;

import com.pose.dao.plan.PlanDao;
import com.pose.exception.plan.AddFailException;
import com.pose.pojo.Problem;
import com.pose.pojo.Report;
import com.pose.pojo.plan.Plan;
import com.pose.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("planService")
public class PlanServiceImpl implements PlanService{
    private EverydayPlanService everydayPlanService;
    private PlanDao planDao;

    @Autowired
    public void setEverydayPlanService(EverydayPlanService everydayPlanService) {
        this.everydayPlanService = everydayPlanService;
    }

    @Autowired
    @Qualifier("planDao")
    public void setPlanDao(PlanDao planDao) {
        this.planDao = planDao;
    }

    @Override
    public Plan queryPlan(String reportId) {
        return planDao.queryPlanById(reportId);
    }


    @Override
    public boolean addPlan(Plan plan) {
        if (planDao.addPlan(plan) == 0){
            throw new AddFailException("创建计划失败");
        }
        return everydayPlanService.generateWeekPlan(plan.getReportId());
    }
}
