package com.pose.controller;

import com.pose.pojo.Problem;
import com.pose.pojo.Report;
import com.pose.pojo.User;
import com.pose.service.report.ReportService;
import com.pose.utils.Constants;
import com.pose.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private ReportService reportService;

    @Autowired
    @Qualifier("reportService")
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("")
    public ResponseEntity<ServerResponse> addReport(@RequestPart("data") Report report,
                                                    @RequestPart("body") List<MultipartFile> bodies,
                                                    @RequestPart("file") List<MultipartFile> files,
                                                    HttpServletRequest request,
                                                    HttpSession session){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        report.setUserId(user.getId());
        report.setId(uuid);
        if (reportService.addReport(report, bodies, files,
                request.getSession().getServletContext().getRealPath(Constants.REPORT_IMAGE_PATH))){
            return new ResponseEntity<>(new ServerResponse(uuid), HttpStatus.CREATED);
        }else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ServerResponse<List> queryReportList(HttpSession session){
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        List<Report> reportList = reportService.queryReportListByUserId(user.getId());
        return new ServerResponse<>(reportList);
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<ServerResponse> queryReport(@PathVariable String reportId, HttpSession session){
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        Report report = reportService.queryReportById(reportId);
        if (report.getUserId().equals(user.getId())){
            return new ResponseEntity<>(new ServerResponse(report), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/latest")
    public ServerResponse<Report> queryLatestReport(HttpSession session){
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        Report report = reportService.queryLatestReport(user.getId());
        return new ServerResponse<>(report);
    }

    @GetMapping("/check")
    public ServerResponse checkReport(HttpSession session){
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        Report report = reportService.queryLatestReport(user.getId());
        if (report == null){
            return new ServerResponse("0");
        }else {
            return new ServerResponse("1");
        }
    }

    @GetMapping(value = "/{reportId}/{problemName}", produces = {MediaType.IMAGE_JPEG_VALUE})
    public byte[] getImage(@PathVariable String reportId, @PathVariable String problemName){
        Problem problem;

        switch (problemName){
            case "front":
            case "side":
            case "back":
                problem = null;break;
            default:
                problem = new Problem();
                problem.setReportId(reportId);
                problem.setName(problemName);
        }

        if (problem == null){
            return reportService.getBodyImage(reportId, problemName);
        }else {
            return reportService.getProblemImage(problem);
        }
    }

}
