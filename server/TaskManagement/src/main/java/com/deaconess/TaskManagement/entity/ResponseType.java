package com.deaconess.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "response_type")
public class ResponseType {
    @Id
    private Long responseType;

    private String responseSystem;


    public String getResponseSystem() {
        return responseSystem;
    }

    public void setResponseSystem(String responseSystem) {
        this.responseSystem = responseSystem;
    }

    public Long getResponseType() {
        return responseType;
    }

    public void setResponseType(Long responseType) {
        this.responseType = responseType;
    }
}
