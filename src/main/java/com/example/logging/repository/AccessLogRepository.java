package com.example.logging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.logging.log.AccessLog;

public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
}