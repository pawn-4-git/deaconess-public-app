package com.deaconess.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.NamedQuery;

public class QuestionAnswerMenuDetailAnswerId {
    @Id
    private String urlPath;
    @Id
    private Integer detailNo;
    @Id
    private Integer answerNo;

    public String getUrlPath() {
        return urlPath;
    }

    public Integer getDetailNo() {
        return detailNo;
    }

    public Integer getAnswerNo() {
        return answerNo;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public void setDetailNo(Integer detailNo) {
        this.detailNo = detailNo;
    }

    public void setAnswerNo(Integer answerNo) {
        this.answerNo = answerNo;
    }
}
