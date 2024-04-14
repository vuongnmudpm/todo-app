package com.vuongnm.repository;

import com.vuongnm.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LabelRepository extends JpaRepository<Label, Long> {
    Optional<Label> findByLabelName(@Param("labelName") String labelName);
}
