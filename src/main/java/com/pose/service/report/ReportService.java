package com.pose.service.report;

import com.pose.pojo.Body;
import com.pose.pojo.Correction;
import com.pose.pojo.Problem;
import com.pose.pojo.Report;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ReportService {
    //新增报告
    boolean addReport(Report report, List<MultipartFile> bodies, List<MultipartFile> files, String rootPath);

    //删除报告
    boolean deleteReportById(String id);

    //获取用户报告列表(不用显示具体问题)
    List<Report> queryReportListByUserId(String userId);

    //获取单个列表信息(包含具体问题)
    Report queryReportById(String id);

    Report queryLatestReport(String userId);

    //获取单个问题图片
    byte[] getProblemImage(Problem problem);

    byte[] getBodyImage(String reportId, String bodyType);

    //根据报告生成Corrections
    List<Correction> getCorrectionListByReport(String reportId);

    //上传单个问题图片
    boolean updateProblemImage(Problem problem);
}
