package com.pose.dao;

import com.pose.pojo.Body;
import com.pose.pojo.Problem;
import com.pose.pojo.Report;

import java.util.List;

public interface ReportDao {
    //新增报告
    int addReport(Report report);

    //删除报告
    int deleteReportById(String id);

    //获取用户报告列表(不用显示具体问题)
    List<Report> queryReportListByUserId(String userId);

    //获取单个列表信息(包含具体问题)
    Report queryReportById(String id);

    //获取最新的报告
    Report queryLatestReport(String userId);

    //获取单个问题(用于获取图片)
    Problem queryProblem(Problem problem);

    Body queryBody(String reportId);

    //修改单个问题（用于上传图片）
    int updateProblem(Problem problem);
}
