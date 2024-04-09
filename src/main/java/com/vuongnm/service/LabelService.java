package com.vuongnm.service;

import com.vuongnm.model.Label;
import com.vuongnm.repository.LabelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {
    @Autowired
    LabelRepository labelRepository;

    public List<Label> getAll() {
        return labelRepository.findAll();
    }

    public Label createLabel(Label lable) {
        return labelRepository.save(lable);
    }

    public Label getLabelById(Long id) {
        Optional<Label> optionalLabel = labelRepository.findById(id);
        if (optionalLabel.isPresent()) {
            return optionalLabel.get();
        } else {
            return null;
        }
    }

    public Label getLabelByName(String labelname) {
        Optional<Label> optionalLabel = labelRepository.findByLabelname(labelname);
        if (optionalLabel.isPresent()) {
            return optionalLabel.get();
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        labelRepository.deleteById(id);
    }

    public Label updateLabel(Long labelId, Label updateLabel) {
        Optional<Label> labelOptional = labelRepository.findById(labelId);
        if (labelOptional.isPresent()) {
            Label existingLabel = labelOptional.get();
            existingLabel.setLabelname(updateLabel.getLabelname());
            return labelRepository.save(existingLabel);
        } else {
            throw new EntityNotFoundException("Label not found with ID: " + labelId);
        }
    }
}
