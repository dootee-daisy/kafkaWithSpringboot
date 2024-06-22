package com.example.model;

import java.util.Date;

public class StatisticDTO {
    private String message;
    private Date createdDate;

    public StatisticDTO(Date createdDate, String message) {
        this.createdDate = createdDate;
        this.message = message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
