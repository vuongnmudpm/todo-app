package com.vuongnm.controller;

import com.vuongnm.model.Label;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelService labelService;

    @RequestMapping("/get-all")
    public List<Label> getAll() {
        return labelService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Label>> createLabel(@RequestBody Label label) {
        return ApiResponse.buildResponse(labelService.createLabel(label), "success", true, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Label>> getLabelById(@PathVariable Long id) {
        Label label = labelService.getLabelById(id);
        if (label != null) {
            return ApiResponse.buildResponse(label, "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/labelname/{labelname}")
    public ResponseEntity<ApiResponse<Label>> getLabelByName(@PathVariable String labelname) {
        Label label = labelService.getLabelByName(labelname);
        if (label != null) {
            return ApiResponse.buildResponse(label, "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if (labelService.getLabelById(id) != null) {
            labelService.deleteById(id);
            return new ResponseEntity<>("Label deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Label not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Label>> updateUser(@PathVariable Long id, @RequestBody Label label) {
        if (labelService.getLabelById(id) != null) {
            return ApiResponse.buildResponse(labelService.updateLabel(id, label), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }
}
