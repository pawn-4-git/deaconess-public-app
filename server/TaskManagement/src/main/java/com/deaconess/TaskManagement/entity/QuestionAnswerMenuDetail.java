package com.deaconess.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import org.hibernate.annotations.NamedQuery;

@Entity
@IdClass(QuestionAnswerMenuDetailId.class)
@Table(name = "question_answer_menu_detail")
@NamedQuery(name = "QuestionAnswerMenuDetail.findPath", query = "FROM QuestionAnswerMenuDetail t WHERE t.urlPath = :urlPath ORDER BY t.detailNo")
public class QuestionAnswerMenuDetail {
    @Id
    private String urlPath;
    @Id
    private Integer detailNo;
    private String detailName;

    public String getUrlPath() {
        return urlPath;
    }

    public Integer getDetailNo() {
        return detailNo;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public void setDetailNo(Integer detailNo) {
        this.detailNo = detailNo;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }
}
