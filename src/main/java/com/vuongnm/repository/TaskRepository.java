package com.vuongnm.repository;

import com.vuongnm.model.Task;
import com.vuongnm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<List<Task>> getByCompleted(Boolean completed);

    public Optional<List<Task>> findByUser(@Param("user") User user);
}
