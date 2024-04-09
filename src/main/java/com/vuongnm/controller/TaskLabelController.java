package com.vuongnm.controller;

import com.vuongnm.model.Label;
import com.vuongnm.model.TaskLabel;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.service.LabelService;
import com.vuongnm.service.TaskLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasklabel")
public class TaskLabelController {
    @Autowired
    TaskLabelService taskLabelService;
    @Autowired
    LabelService labelService;

    @GetMapping("/get-all")
    public List<TaskLabel> getAll() {
        return taskLabelService.getAll();
    }

    @GetMapping("/getByLabel/{labelid}")
    public ResponseEntity<ApiResponse<List<TaskLabel>>> getTaskLabelByLabel(@PathVariable("labelid") Long labelid) {
        Label label = labelService.getLabelById(labelid);
        if (label != null) {
            return ApiResponse.buildResponse(taskLabelService.getTaskLabelByLabel(label), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

}
