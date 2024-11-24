package com.deaconess.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.NamedQuery;

public class QuestionAnswerMenuDetailId {
    @Id
    private String urlPath;
    @Id
    private Integer detailNo;

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public void setDetailNo(Integer detailNo) {
        this.detailNo = detailNo;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public Integer getDetailNo() {
        return detailNo;
    }
}
