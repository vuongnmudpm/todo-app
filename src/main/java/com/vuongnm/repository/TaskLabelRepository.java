package com.vuongnm.repository;

import com.vuongnm.model.Label;
import com.vuongnm.model.TaskLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskLabelRepository extends JpaRepository<TaskLabel, Long> {
    public Optional<List<TaskLabel>> findByLabel(@Param("label") Label label);
}
