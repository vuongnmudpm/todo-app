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
    public ResponseEntity<ApiResponse<List<Label>>> getAll() {
        return labelService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Label>> createLabel(@RequestBody Label label) {
        return labelService.createLabel(label);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Label>> getLabelById(@PathVariable Long id) {
        return labelService.getLabelById(id);
    }

    @GetMapping("/labelName/{labelName}")
    public ResponseEntity<ApiResponse<Label>> getLabelByName(@PathVariable String labelName) {
        return labelService.getLabelByName(labelName);
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
        return labelService.updateLabel(id, label);
    }
}
