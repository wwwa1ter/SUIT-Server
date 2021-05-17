package com.pose.controller;

import com.pose.pojo.Reward;
import com.pose.pojo.User;
import com.pose.service.plan.RewardService;
import com.pose.utils.Constants;
import com.pose.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private RewardService rewardService;

    @Autowired
    public void setRewardService(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("")
    public ServerResponse getRewardList(HttpSession session){
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        String userId = user.getId();
        return new ServerResponse<>(rewardService.getRewardList(userId));
    }

    @PutMapping("")
    public void updateReward(Reward reward){
        rewardService.updateReward(reward);
    }
}
