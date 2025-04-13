package com.zw.jimfish.Smart.School.Management.System.SSMS.service.exceptions;

import java.time.Instant;

public class ErrorResponse {
        private String code;
        private String message;
        private int status;
        private Instant timestamp;

        // Constructors
        public ErrorResponse() {
            this.timestamp = Instant.now();
        }

        public ErrorResponse(String code, String message, int status) {
            this();
            this.code = code;
            this.message = message;
            this.status = status;
        }

        // Getters and Setters
        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public int getStatus() { return status; }
        public void setStatus(int status) { this.status = status; }
        public Instant getTimestamp() { return timestamp; }

}
