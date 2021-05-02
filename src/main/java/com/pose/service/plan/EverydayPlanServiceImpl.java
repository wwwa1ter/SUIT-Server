package com.pose.service.plan;

import com.pose.dao.plan.EverydayPlanDao;
import com.pose.exception.plan.GeneratePlanFailException;
import com.pose.exception.plan.ReportNotFoundException;
import com.pose.exception.plan.UpdatePlanException;
import com.pose.pojo.Correction;
import com.pose.pojo.EverydayCorrection;
import com.pose.pojo.Movement;
import com.pose.pojo.Report;
import com.pose.pojo.plan.EverydayPlan;
import com.pose.pojo.plan.Plan;
import com.pose.service.report.ReportService;
import com.pose.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service("everydayPlanService")
public class EverydayPlanServiceImpl implements EverydayPlanService{

    private PlanService planService;
    private ReportService reportService;
    private EverydayPlanDao everydayPlanDao;

    @Autowired
    public void setPlanService(PlanService planService) {
        this.planService = planService;
    }

    @Autowired
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @Autowired
    public void setEverydayPlanDao(EverydayPlanDao everydayPlanDao) {
        this.everydayPlanDao = everydayPlanDao;
    }

//    @Transactional
    @Override
    public boolean generateWeekPlan(String reportId) {
        Plan plan = planService.queryPlan(reportId);
        List<EverydayCorrection> everydayCorrections = new LinkedList<>();
        for (Correction correction : plan.getCorrections()) {
            EverydayCorrection everydayCorrection = new EverydayCorrection(plan.getReportId(), null, 0, correction);
            everydayCorrections.add(everydayCorrection);
        }
        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
        for (int i = 0; i < 7; i++) {
            EverydayPlan everydayPlan = new EverydayPlan(calendar.getTime());
            //设置当天的动作
            everydayPlan.setReportId(plan.getReportId());
            everydayPlan.setCorrections(everydayCorrections);
            if (everydayPlanDao.addEverydayPlan(everydayPlan) == 0){
                throw new GeneratePlanFailException("生成下周计划失败");
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        return true;
    }

    @Override
    public EverydayPlan getTodayPlan(String userId) {
        Report report = reportService.queryLatestReport(userId);
        if (report == null){
            throw new ReportNotFoundException("该用户不存在检测报告，请先检测");
        }
        EverydayPlan everydayPlan = new EverydayPlan();
        everydayPlan.setReportId(report.getId());
        everydayPlan.setDate(new Date());
        EverydayPlan queryEverydayPlan = everydayPlanDao.queryEverydayPlan(everydayPlan);
        if (queryEverydayPlan == null){
            generateWeekPlan(report.getId());
            queryEverydayPlan = everydayPlanDao.queryEverydayPlan(everydayPlan);
        }
        for (EverydayCorrection correction : queryEverydayPlan.getCorrections()) {
            Movement movement = correction.getCorrection().getMovement();
            if (movement.getContent() != null){
                movement.setContent(String.format("movements/%s", movement.getName()));
            }
        }
        return queryEverydayPlan;
    }

    @Override
    public boolean updateTodayPlan(EverydayCorrection correction) {
        if (everydayPlanDao.updateEverydayPlan(correction) > 0){
            return true;
        }else {
            throw new UpdatePlanException("更新计划动作失败");
        }
    }

}
