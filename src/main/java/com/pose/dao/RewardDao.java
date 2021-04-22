package com.pose.dao;

import com.pose.pojo.Report;
import com.pose.pojo.Reward;

import java.util.List;

public interface RewardDao {
    //获取奖励列表
    List<Reward> queryRewardList(String userId);

    //更新奖励
    int updateReward(Reward reward);

}
