package com.vuongnm.service;

import com.vuongnm.model.Label;
import com.vuongnm.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LabelService {

    public ResponseEntity<ApiResponse<List<Label>>> getAll();

    public ResponseEntity<ApiResponse<Label>> createLabel(Label lable);

    public ResponseEntity<ApiResponse<Label>> getLabelById(Long id);

    public ResponseEntity<ApiResponse<Label>> getLabelByName(String labelname);

    public ResponseEntity<String> deleteById(Long id);

    public ResponseEntity<ApiResponse<Label>> updateLabel(Long labelId, Label updateLabel);
}
