package com.pose.service.plan;

import com.pose.dao.CorrectionDao;
import com.pose.pojo.Correction;
import com.pose.pojo.Movement;
import com.pose.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service("correctionService")
public class CorrectionServiceImpl implements CorrectionService{

    private CorrectionDao correctionDao;

    @Autowired
    @Qualifier("correctionDao")
    public void setCorrectionDao(CorrectionDao correctionDao) {
        this.correctionDao = correctionDao;
    }

    @Override
    public List<Correction> queryCorrectionByProblem(Problem problem) {
        List<Correction> corrections = correctionDao.queryCorrectionByProblem(problem);
        for (Correction correction : corrections) {
            Movement movement = correction.getMovement();
            if (movement.getContent() != null){
                movement.setContent(String.format("movements/%s", movement.getName()));
            }
        }
        return corrections;
    }

    @Override
    public List<Correction> queryCorrectionList(List<Problem> problems) {
        List<Correction> corrections = new LinkedList<>();
        for (Problem problem : problems) {
            if (problem.getExtent() > 0 && queryCorrectionByProblem(problem) != null){
                corrections.addAll(queryCorrectionByProblem(problem));
            }
        }
        return corrections;
    }
}
