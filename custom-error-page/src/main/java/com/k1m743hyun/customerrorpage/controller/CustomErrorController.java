package com.k1m743hyun.customerrorpage.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping(value="${server.error.path:${error.path:/error}}", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {

        Map<String, Object> responseBody = new HashMap<>();

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return ResponseEntity.notFound().build();
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                responseBody.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
                return ResponseEntity.internalServerError().body(responseBody);
            }
        }

        return ResponseEntity.badRequest().body(responseBody);
    }
}
