package com.codesoom.assignment;

import java.util.Date;

public class ErrorResponse {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;

    public ErrorResponse(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("{ statusCode = %s, timestamp = %s, message = %s, description = %s }",
                statusCode, timestamp, message, description);
    }

}
