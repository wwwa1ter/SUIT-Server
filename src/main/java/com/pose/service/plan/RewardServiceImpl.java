package com.pose.service.plan;

import com.pose.dao.RewardDao;
import com.pose.exception.plan.UpdatePlanException;
import com.pose.pojo.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rewardService")
public class RewardServiceImpl implements RewardService{

    private RewardDao rewardDao;

    @Autowired
    @Qualifier("rewardDao")
    public void setRewardDao(RewardDao rewardDao) {
        this.rewardDao = rewardDao;
    }

    @Override
    public List<Reward> getRewardList(String userId) {
        return rewardDao.queryRewardList(userId);
    }

    @Override
    public Reward getReward(String reportId) {
        return null;
    }

    @Override
    public boolean updateReward(Reward reward) {
        if (rewardDao.updateReward(reward) > 0){
            return true;
        }else {
            throw new UpdatePlanException("更新计划奖励失败");
        }
    }
}
