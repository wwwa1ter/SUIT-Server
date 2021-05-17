package com.pose.controller;

import com.pose.pojo.Correction;
import com.pose.service.plan.CorrectionService;
import com.pose.service.report.ReportService;
import com.pose.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/corrections")
public class CorrectionController {

    private CorrectionService correctionService;
    private ReportService reportService;

    @Autowired
    @Qualifier("correctionService")
    public void setCorrectionService(CorrectionService correctionService) {
        this.correctionService = correctionService;
    }

    @Autowired
    @Qualifier("reportService")
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{reportId}")
    public ServerResponse<List<Correction>> getCorrectionListByReport(@PathVariable String reportId){
        List<Correction> corrections = reportService.getCorrectionListByReport(reportId);
        return new ServerResponse<>(corrections);
    }
}
