package com.vuongnm.service;

import com.vuongnm.model.Label;
import com.vuongnm.model.TaskLabel;
import com.vuongnm.repository.TaskLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskLabelService {
    @Autowired
    TaskLabelRepository taskLabelRepository;

    public List<TaskLabel> getAll() {
        return taskLabelRepository.findAll();
    }

    public List<TaskLabel> getTaskLabelByLabel(Label label) {
        Optional<List<TaskLabel>> optionalTaskLabels = taskLabelRepository.findByLabel(label);
        if (optionalTaskLabels.isPresent()) {
            return optionalTaskLabels.get();
        } else {
            return Collections.emptyList();
        }
    }
}
