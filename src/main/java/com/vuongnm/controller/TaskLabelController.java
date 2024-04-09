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
    public ResponseEntity<ApiResponse<List<TaskLabel>>> getAll() {
        return taskLabelService.getAll();
    }

    @GetMapping("/getByLabel/{labelId}")
    public ResponseEntity<ApiResponse<List<TaskLabel>>> getTaskLabelByLabel(@PathVariable("labelId") Long labelId) {
        Label label = labelService.getLabelById(labelId).getBody().getData();
        return taskLabelService.getTaskLabelByLabel(label);
    }

}
