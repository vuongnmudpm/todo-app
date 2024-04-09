package com.vuongnm.service.implement;

import com.vuongnm.model.Label;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.repository.LabelRepository;
import com.vuongnm.service.LabelService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelServiceImplement implements LabelService {
    @Autowired
    LabelRepository labelRepository;

    @Override
    public ResponseEntity<ApiResponse<List<Label>>> getAll() {
        return ApiResponse.buildResponse(labelRepository.findAll(), "success", true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<Label>> createLabel(Label lable) {
        return ApiResponse.buildResponse(labelRepository.save(lable), "success", true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<Label>> getLabelById(Long id) {
        Optional<Label> optionalLabel = labelRepository.findById(id);
        if (optionalLabel.isPresent()) {
            return ApiResponse.buildResponse(optionalLabel.get(), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Label>> getLabelByName(String labelname) {
        Optional<Label> optionalLabel = labelRepository.findByLabelname(labelname);
        if (optionalLabel.isPresent()) {
            return ApiResponse.buildResponse(optionalLabel.get(), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        if (labelRepository.findById(id) != null) {
            labelRepository.deleteById(id);
            return new ResponseEntity<>("Label deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Label not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Label>> updateLabel(Long labelId, Label updateLabel) {
        Optional<Label> labelOptional = labelRepository.findById(labelId);
        if (labelOptional.isPresent()) {
            Label existingLabel = labelOptional.get();
            existingLabel.setLabelname(updateLabel.getLabelname());
            return ApiResponse.buildResponse(labelRepository.save(existingLabel), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }
}
