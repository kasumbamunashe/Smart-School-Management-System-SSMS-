package com.zw.jimfish.Smart.School.Management.System.SSMS.service.exceptions;

public class Error {
    private final int status;
    private final String error;

    private Error(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public static Error of(int status, String error) {
        return new Error(status, error);
    }

    @Override
    public String toString() {
        return "Error{" +
                "status=" + status +
                ", error='" + error + '\'' +
                '}';
    }
}
