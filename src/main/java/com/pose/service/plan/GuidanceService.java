package com.pose.service.plan;

import com.pose.pojo.Guidance;

import java.util.List;

public interface GuidanceService {
    boolean addGuidance(Guidance guidance);
    boolean deleteGuidance(Guidance guidance);
    Guidance queryGuidance(String movementName, int sequence);
    List<Guidance> queryGuidanceList(String movementName);
    boolean updateGuidance(Guidance guidance);

    byte[] getGuidanceImage(String movementName, int sequence);

}
