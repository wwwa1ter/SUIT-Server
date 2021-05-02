package com.pose.service.report;

import com.pose.dao.ReportDao;
import com.pose.pojo.Body;
import com.pose.pojo.Correction;
import com.pose.pojo.Problem;
import com.pose.pojo.Report;
import com.pose.service.plan.CorrectionService;
import com.pose.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;

@Service("reportService")
public class ReportServiceImpl implements ReportService{

    private ReportDao reportDao;
    private CorrectionService correctionService;

    @Autowired
    @Qualifier("reportDao")
    public void setReportDao(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Autowired
    @Qualifier("correctionService")
    public void setCorrectionService(CorrectionService correctionService) {
        this.correctionService = correctionService;
    }

    @Override
    public boolean addReport(Report report, List<MultipartFile> bodies, List<MultipartFile> files, String rootPath) {
        report.setDate(new Date());

        if (bodies != null) {
            report.setBody(new Body());
            for (int i = 0; i < bodies.size(); i++) {
                String filename = report.getId() + "0" + i + ".jpeg";
                String filenameOrigin = bodies.get(i).getOriginalFilename().split("\\.")[0];
                if (ImageUtil.saveFile(bodies.get(i), rootPath, filename)){
                    switch (filenameOrigin){
                        case "front":
                            report.getBody().setFront(rootPath + filename);break;
                        case "side":
                            report.getBody().setSide(rootPath + filename);break;
                        case "back":
                            report.getBody().setBack(rootPath + filename);break;
                        default:
                            System.out.println("Origin Name: " + filenameOrigin);
                    }
                }
            }
        }

        if (files != null) {
            for (int i = 0; i < files.size(); i++) {
                String filename = report.getId() + "1" + i + ".jpeg";
                if (ImageUtil.saveFile(files.get(i), rootPath, filename)){
                    report.getProblems().get(i).setImage(rootPath + filename);
                }
            }
        }
        return (reportDao.addReport(report)>0);
    }
//
//    public boolean addReport(Report report){
//        return this.addReport(report, null, null);
//    }

    @Override
    public boolean deleteReportById(String id) {
        return reportDao.deleteReportById(id)>0;
    }

    @Override
    public List<Report> queryReportListByUserId(String userId) {
        return reportDao.queryReportListByUserId(userId);
    }

    @Override
    public Report queryReportById(String id) {
        Report report = reportDao.queryReportById(id);
        if (report != null) {
            Body body = report.getBody();
            if (body.getFront() != null) {
                body.setFront(String.format("reports/%s/%s", report.getId(), "front"));
            }
            if (body.getSide() != null) {
                body.setSide(String.format("reports/%s/%s", report.getId(), "side"));
            }
            if (body.getBack() != null) {
                body.setBack(String.format("reports/%s/%s", report.getId(), "back"));
            }
            for (Problem problem : report.getProblems()) {
                if (problem.getImage() != null) {
                    problem.setImage(String.format("reports/%s/%s", report.getId(), problem.getName()));
                }
                if (problem.getContent() != null) {
                    problem.setContent(String.format("problems/%s", problem.getName()));
                }
            }
        }
        return report;
    }

    @Override
    public Report queryLatestReport(String userId) {
        Report report = reportDao.queryLatestReport(userId);
        if (report != null) {
            for (Problem problem : report.getProblems()) {
                if (problem.getContent() != null) {
                    problem.setContent(String.format("problems/%s", problem.getName()));
                }
            }
        }
        return report;
    }

    @Override
    public byte[] getProblemImage(Problem problem){
        //这里理解的img就是他的路径
        String imgPath = reportDao.queryProblem(problem).getImage();
        return ImageUtil.getImage(imgPath);
    }

    @Override
    public byte[] getBodyImage(String reportId, String bodyType) {
        Body body = reportDao.queryBody(reportId);
        String imgPath;
        switch (bodyType){
            case "front":
                imgPath = body.getFront();break;
            case "side":
                imgPath = body.getSide();break;
            case "back":
                imgPath = body.getBack();break;
            default:
                imgPath = null;

        }
        return ImageUtil.getImage(imgPath);
    }

    @Override
    public List<Correction> getCorrectionListByReport(String reportId) {
        List<Problem> problems = queryReportById(reportId).getProblems();
        return correctionService.queryCorrectionList(problems);
    }

    @Override
    public boolean updateProblemImage(Problem problem) {
        //需要从前端得到文件的byte流,img从前端得到
        byte[] img = new byte[1024];
        //前端得到名称，存储
        String imgPath = problem.getImage();
        File file = new File(imgPath);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(img);
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //如果service层完成的只是更新数据库里面的路径，不需要存储图片，则只要下面这一句
        return (reportDao.updateProblem(problem)>0);
    }
}
