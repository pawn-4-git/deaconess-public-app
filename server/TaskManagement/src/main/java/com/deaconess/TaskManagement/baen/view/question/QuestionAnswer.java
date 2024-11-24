package com.deaconess.TaskManagement.baen.view.question;

import com.deaconess.TaskManagement.entity.QuestionAnswerMenuDetail;
import com.deaconess.TaskManagement.entity.QuestionAnswerMenuDetailAnswer;

import java.util.List;

public class QuestionAnswer {
    private QuestionAnswerMenuDetail questionAnswerMenuDetail;
    private List<QuestionAnswerMenuDetailAnswer> questionAnswerMenuDetailAnswerList;

    public QuestionAnswerMenuDetail getQuestionAnswerMenuDetail() {
        return questionAnswerMenuDetail;
    }

    public List<QuestionAnswerMenuDetailAnswer> getQuestionAnswerMenuDetailAnswerList() {
        return questionAnswerMenuDetailAnswerList;
    }

    public void setQuestionAnswerMenuDetail(QuestionAnswerMenuDetail questionAnswerMenuDetail) {
        this.questionAnswerMenuDetail = questionAnswerMenuDetail;
    }

    public void setQuestionAnswerMenuDetailAnswerList(List<QuestionAnswerMenuDetailAnswer> questionAnswerMenuDetailAnswerList) {
        this.questionAnswerMenuDetailAnswerList = questionAnswerMenuDetailAnswerList;
    }
}
