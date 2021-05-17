package com.pose.controller;

import com.pose.pojo.EverydayCorrection;
import com.pose.pojo.User;
import com.pose.pojo.plan.EverydayPlan;
import com.pose.pojo.plan.Plan;
import com.pose.service.plan.EverydayPlanService;
import com.pose.service.plan.PlanService;
import com.pose.utils.Constants;
import com.pose.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/plans")
public class PlanController {
    private PlanService planService;
    private EverydayPlanService everydayPlanService;

    @Autowired
    @Qualifier("planService")
    public void setPlanService(PlanService planService) {
        this.planService = planService;
    }

    @Autowired
    public void setEverydayPlanService(EverydayPlanService everydayPlanService) {
        this.everydayPlanService = everydayPlanService;
    }

    @PostMapping("")
    public ResponseEntity addPlan(@RequestBody Plan plan){
        if (planService.addPlan(plan)){
            return new ResponseEntity(HttpStatus.CREATED);
        }else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{reportId}")
    public ServerResponse<Plan> getPlan(@PathVariable String reportId){
        System.out.printf("Have a request: " + reportId);
        Plan plan = planService.queryPlan(reportId);
        plan.setCorrections(null);
        return new ServerResponse<>(plan);
    }

    @GetMapping("/today")
    public ServerResponse<EverydayPlan> getTodayPlan(HttpSession session){
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        String userId = user.getId();
        return new ServerResponse<>(everydayPlanService.getTodayPlan(userId));
    }

    @PutMapping("/everydayPlan")
    public void updateEverydayPlan(@RequestBody EverydayCorrection correction){
        everydayPlanService.updateTodayPlan(correction);
    }

}
