package com.example.logging.log;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "access_log")
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uri;
    private String query;
    private String ip;
    private String device;
    private LocalDateTime createdAt;

    protected AccessLog() {}

    public AccessLog(String uri, String query, String ip, String device) {
        this.uri = uri;
        this.query = query;
        this.ip = ip;
        this.device = device;
        this.createdAt = LocalDateTime.now();
    }

    // getters (optional setters if needed)
    public String getUri() { return uri; }
    public String getQuery() { return query; }
    public String getIp() { return ip; }
    public String getDevice() { return device; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    
}