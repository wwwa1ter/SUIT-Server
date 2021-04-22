package com.pose.dao;

import com.pose.pojo.Problem;

public interface ProblemDao {
    //新增问题
    int addProblem(Problem problem);

    //删除问题
    int deleteProblemByName(String problemName);

    //获得问题
    Problem queryProblemByName(String problemName);

    //修改问题
    int updateProblem(Problem problem);
}
