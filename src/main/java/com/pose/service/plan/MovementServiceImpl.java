package com.pose.service.plan;

import com.pose.dao.MovementDao;
import com.pose.exception.guidance.HtmlNotFoundException;
import com.pose.pojo.Movement;
import com.pose.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("movementService")
public class MovementServiceImpl implements MovementService{

    private MovementDao movementDao;

    @Autowired
    public void setMovementDao(MovementDao movementDao) {
        this.movementDao = movementDao;
    }

    @Override
    public String getMovementHtml(String movementName) {
        Movement movement = movementDao.queryMovement(movementName);
        if (movement == null){
            throw new HtmlNotFoundException("该动作不存在");
        }
        String htmlPath = movement.getContent();
        if (htmlPath == null || htmlPath.isEmpty()){
            throw new HtmlNotFoundException("该Html不存在");
        }
        return MyUtil.getHtml(htmlPath);
    }
}
