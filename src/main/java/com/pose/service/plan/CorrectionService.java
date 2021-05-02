package com.pose.service.plan;

import com.pose.pojo.Correction;
import com.pose.pojo.Problem;

import java.util.List;

public interface CorrectionService {
    //根据问题获取纠正方法
    List<Correction> queryCorrectionByProblem(Problem problem);

    //根据问题列表获取纠正方法
    List<Correction> queryCorrectionList(List<Problem> problems);
}
