package com.vuongnm.service;

import com.vuongnm.model.Label;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.repository.LabelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LabelService {

    public ResponseEntity<ApiResponse<List<Label>>> getAll();

    public ResponseEntity<ApiResponse<Label>> createLabel(Label lable);

    public ResponseEntity<ApiResponse<Label>> getLabelById(Long id);

    public ResponseEntity<ApiResponse<Label>> getLabelByName(String labelname);

    public ResponseEntity<String> deleteById(Long id);

    public ResponseEntity<ApiResponse<Label>> updateLabel(Long labelId, Label updateLabel);
}
