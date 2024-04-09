package com.vuongnm.service.implement;

import com.vuongnm.model.Label;
import com.vuongnm.model.TaskLabel;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.repository.TaskLabelRepository;
import com.vuongnm.service.TaskLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskLabelServiceImplement implements TaskLabelService {
    @Autowired
    TaskLabelRepository taskLabelRepository;

    @Override
    public ResponseEntity<ApiResponse<List<TaskLabel>>> getAll() {
        return ApiResponse.buildResponse(taskLabelRepository.findAll(), "success", true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<List<TaskLabel>>> getTaskLabelByLabel(Label label) {
        Optional<List<TaskLabel>> optionalTaskLabels = taskLabelRepository.findByLabel(label);
        if (optionalTaskLabels.isPresent()) {
            return ApiResponse.buildResponse(optionalTaskLabels.get(), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(Collections.emptyList(), "fail", false, HttpStatus.NOT_FOUND);

        }
    }
}
