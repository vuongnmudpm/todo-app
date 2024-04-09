package com.vuongnm.service;

import com.vuongnm.model.Label;
import com.vuongnm.model.TaskLabel;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.repository.TaskLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


public interface TaskLabelService {

    public ResponseEntity<ApiResponse<List<TaskLabel>>> getAll();

    public ResponseEntity<ApiResponse<List<TaskLabel>>> getTaskLabelByLabel(Label label);
}
