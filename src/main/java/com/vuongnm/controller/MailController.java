package com.vuongnm.controller;

import com.vuongnm.model.Task;
import com.vuongnm.service.EmailService;
import com.vuongnm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    TaskService taskService;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0/30 7 * * ?") // Lập lịch gửi thông báo vào 7h30 sáng mỗi ngày
    public void sendTodoNotifications() {
        List<Task> todos = taskService.getTodosDueToday().getBody().getData();
        for (Task todo : todos) {
            String email = todo.getUser().getEmail();
            String subject = "Thông báo: Công việc cần hoàn thành hôm nay";
            String text = "Công việc: " + todo.getTitle() + " cần hoàn thành hôm nay.";
            emailService.sendEmail(email, subject, text);
        }
    }
}
