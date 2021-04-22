package com.pose.dao;

import com.pose.pojo.Guidance;

import java.util.List;

public interface GuidanceDao {
    int addGuidance(Guidance guidance);
    int deleteGuidance(Guidance guidance);
    Guidance queryGuidance(Guidance guidance);
    List<Guidance> queryGuidanceList(String movementName);
    int updateGuidance(Guidance guidance);
}
