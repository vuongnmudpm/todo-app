package com.vuongnm.payload;

import com.vuongnm.util.DateUtil;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.time.ZoneId;

@Data
public class ApiResponse<T> {
    private T data;
    private String message;
    private boolean success;
    private String responseTime;

    public ApiResponse(T data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
        this.responseTime = DateUtil.formatInstant(Instant.now(), ZoneId.systemDefault());
    }

    public static <T> ResponseEntity<ApiResponse<T>> buildResponse(T data, String message, boolean success, HttpStatus status) {
        return new ResponseEntity<>(new ApiResponse<>(data, message, success), status);
    }
}
