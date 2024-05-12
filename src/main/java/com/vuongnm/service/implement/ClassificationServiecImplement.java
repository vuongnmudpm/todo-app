package com.vuongnm.service.implement;

import com.vuongnm.service.ClassificationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Service
public class ClassificationServiecImplement implements ClassificationService {
    @Override
    public String classifyTask(String description) {
        // Chuyển đổi mô tả thành chữ thường và loại bỏ dấu câu
        String lowerDescription = description.toLowerCase().replaceAll("[^a-zA-Z ]", "");

        // Phân loại dựa trên từ khóa trong mô tả
        if (lowerDescription.contains("meeting") || lowerDescription.contains("conference")) {
            return "Meeting";
        } else if (lowerDescription.contains("shopping") || lowerDescription.contains("buy")) {
            return "Shopping";
        } else if (lowerDescription.contains("study") || lowerDescription.contains("learn")) {
            return "Study";
        } else {
            return "Other";
        }
    }
}
