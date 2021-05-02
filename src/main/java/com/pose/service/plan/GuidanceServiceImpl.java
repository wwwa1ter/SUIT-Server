package com.pose.service.plan;

import com.pose.dao.GuidanceDao;
import com.pose.exception.guidance.GuidanceNotFoundException;
import com.pose.pojo.Guidance;
import com.pose.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("guidanceService")
public class GuidanceServiceImpl implements GuidanceService{
    private GuidanceDao guidanceDao;

    @Autowired
    public void setGuidanceDao(GuidanceDao guidanceDao) {
        this.guidanceDao = guidanceDao;
    }

    @Override
    public boolean addGuidance(Guidance guidance) {
        return guidanceDao.addGuidance(guidance) > 0;
    }

    @Override
    public boolean deleteGuidance(Guidance guidance) {
        return guidanceDao.deleteGuidance(guidance) > 0;
    }

    @Override
    public Guidance queryGuidance(String movementName, int sequence) {
        Guidance guidance = new Guidance(movementName, sequence, null, null);
        Guidance queryGuidance = guidanceDao.queryGuidance(guidance);
        if (queryGuidance != null){
            if (queryGuidance.getImage() != null) {
                queryGuidance.setImage(String.format("movements/guidance/image/%s", queryGuidance.getMovementName()));
            }
        }else {
            throw new GuidanceNotFoundException("找不到该动作的指导");
        }
        return queryGuidance;
    }

    @Override
    public List<Guidance> queryGuidanceList(String movementName) {
        List<Guidance> guidances = guidanceDao.queryGuidanceList(movementName);
        if (guidances.isEmpty()){
            throw new GuidanceNotFoundException("找不到该动作的指导");
        }else {
            for (Guidance guidance : guidances) {
                if (guidance.getImage() != null){
                    guidance.setImage(String.format("movements/guidance/image/%s", guidance.getMovementName()));
                }
            }
        }
        return guidances;
    }

    @Override
    public boolean updateGuidance(Guidance guidance) {
        return guidanceDao.updateGuidance(guidance) > 0;
    }

    @Override
    public byte[] getGuidanceImage(String movementName, int sequence) {
        Guidance guidance = new Guidance(movementName, sequence, null, null);
        Guidance queryGuidance = guidanceDao.queryGuidance(guidance);
        String imagePath;
        if (queryGuidance != null){
            imagePath = queryGuidance.getImage();
        }else {
            throw new GuidanceNotFoundException("找不到该动作的指导");
        }

        return ImageUtil.getImage(imagePath);
    }
}
