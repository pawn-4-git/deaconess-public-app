package com.deaconess.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import org.hibernate.annotations.NamedQuery;

@Entity
@IdClass(QuestionAnswerMenuDetailAnswerId.class)
@Table(name = "question_answer_menu_detail_answer")
@NamedQuery(name = "QuestionAnswerMenuDetailAnswer.findDetailNo", query = "FROM QuestionAnswerMenuDetailAnswer t WHERE t.urlPath = :urlPath and t.detailNo = :detailNo ORDER BY t.answerNo")
public class QuestionAnswerMenuDetailAnswer {
    @Id
    private String urlPath;
    @Id
    private Integer detailNo;
    @Id
    private Integer answerNo;
    private String questionText;
    private Integer questionType;
    private Integer responseType;

    public String getUrlPath() {
        return urlPath;
    }

    public Integer getDetailNo() {
        return detailNo;
    }

    public Integer getAnswerNo() {
        return answerNo;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public Integer getResponseType() {
        return responseType;
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

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public void setResponseType(Integer responseType) {
        this.responseType = responseType;
    }
}
