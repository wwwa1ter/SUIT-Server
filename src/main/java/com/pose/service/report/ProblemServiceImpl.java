package com.pose.service.report;

import com.pose.dao.ProblemDao;
import com.pose.exception.guidance.HtmlNotFoundException;
import com.pose.pojo.Problem;
import com.pose.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("problemService")
public class ProblemServiceImpl implements ProblemService{

    private ProblemDao problemDao;

    @Autowired
    public void setProblemDao(ProblemDao problemDao) {
        this.problemDao = problemDao;
    }

    @Override
    public String getProblemHtml(String problemName) {
        Problem problem = problemDao.queryProblemByName(problemName);
        if (problem == null){
            throw new HtmlNotFoundException("该问题不存在");
        }
        String htmlPath = problem.getContent();
        if (htmlPath == null || htmlPath.isEmpty()){
            throw new HtmlNotFoundException("该Html不存在");
        }
        return MyUtil.getHtml(htmlPath);
    }
}
