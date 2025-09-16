package com.example.logging.log;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.logging.repository.AccessLogRepository;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private final AccessLogRepository accessLogRepository;

    public LoggingInterceptor(AccessLogRepository accessLogRepository) {
        this.accessLogRepository = accessLogRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        String uri = request.getRequestURI();
        String query = request.getQueryString();
        String ip = request.getRemoteAddr();
        String device = request.getHeader("User-Agent");

        // Save to DB
        AccessLog log = new AccessLog(uri, query, ip, device);
        accessLogRepository.save(log);

        // Also log to console
        System.out.printf("[ACCESS] uri=%s, query=%s, ip=%s, device=%s%n",
                          uri, query, ip, device);

        return true;
    }
}
