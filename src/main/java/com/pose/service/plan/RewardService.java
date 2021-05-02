package com.pose.service.plan;

import com.pose.pojo.Reward;

import java.util.List;

public interface RewardService {
    //根据用户id获取该用户的所有历史奖励
    List<Reward> getRewardList(String userId);
    //根据报告id(即计划id)获取相应计划的奖励内容
    Reward getReward(String reportId);
    //更新用户的奖励状态
    boolean updateReward(Reward reward);
}
