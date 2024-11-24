package com.deaconess.TaskManagement.baen.api;

public class ApiKey {
    private Long envId;
    private String apiKey;

    public Long getEnvId() {
        return envId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
