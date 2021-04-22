package com.pose.dao;

import com.pose.pojo.Correction;
import com.pose.pojo.Problem;

import java.util.List;

public interface CorrectionDao {
    //新增纠正方法
    int addCorrection(Correction correction);

    //删除纠正方法
    int deleteCorrectionById(String id);

    //根据问题获取纠正方法
    List<Correction> queryCorrectionByProblem(Problem problem);

    //修改纠正方法
    int updateCorrection(Correction correction);
}
