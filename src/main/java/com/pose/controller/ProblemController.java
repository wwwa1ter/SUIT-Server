package com.pose.controller;

import com.pose.service.report.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problems")
public class ProblemController {
    private ProblemService problemService;

    @Autowired
    public void setProblemService(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping(value = "/{problemName}", produces = "text/html;charset=utf-8")
    public String getProblemHtml(@PathVariable String problemName){
        return problemService.getProblemHtml(problemName);
    }

}
