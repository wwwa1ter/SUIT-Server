package com.pose.controller;

import com.pose.pojo.Guidance;
import com.pose.service.plan.GuidanceService;
import com.pose.service.plan.MovementService;
import com.pose.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementController {

    private MovementService movementService;
    private GuidanceService guidanceService;

    @Autowired
    public void setMovementService(MovementService movementService) {
        this.movementService = movementService;
    }

    @Autowired
    public void setGuidanceService(GuidanceService guidanceService) {
        this.guidanceService = guidanceService;
    }

    @GetMapping(value = "/{movementName}", produces = "text/html;charset=utf-8")
    public String getMovementHtml(@PathVariable String movementName){
        return movementService.getMovementHtml(movementName);
    }

    @GetMapping("/guidance/{movementName}")
    public ServerResponse<List<Guidance>> getGuidanceList(@PathVariable String movementName){
        List<Guidance> guidances = guidanceService.queryGuidanceList(movementName);
        return new ServerResponse<>(guidances);
    }

    @GetMapping("/guidance/{movementName}/{sequence}")
    public ServerResponse<Guidance> getGuidance(@PathVariable String movementName, @PathVariable String sequence){
        Guidance guidance = guidanceService.queryGuidance(movementName, Integer.valueOf(sequence));
        return new ServerResponse<>(guidance);
    }

    @GetMapping(value = "/guidance/image/{movementName}/{sequence}", produces = {MediaType.IMAGE_JPEG_VALUE})
    public byte[] getGuidanceImage(@PathVariable String movementName, @PathVariable String sequence){
        return guidanceService.getGuidanceImage(movementName, Integer.valueOf(sequence));
    }

}
