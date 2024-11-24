package com.deaconess.TaskManagement.baen.view.question;

import java.util.List;

public class Question {
    private String urlPath;
    private String detailNo;
    private String answerNo;
    private String inputText;
    private String responseText;
    private List<BeforeAnswer> beforeAnswer;

    public String getUrlPath() {
        return urlPath;
    }

    public String getDetailNo() {
        return detailNo;
    }

    public String getAnswerNo() {
        return answerNo;
    }

    public String getInputText() {
        return inputText;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }


    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public void setDetailNo(String detailNo) {
        this.detailNo = detailNo;
    }

    public void setAnswerNo(String answerNo) {
        this.answerNo = answerNo;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public List<BeforeAnswer> getBeforeAnswer() {
        return beforeAnswer;
    }

    public void setBeforeAnswer(List<BeforeAnswer> beforeAnswer) {
        this.beforeAnswer = beforeAnswer;
    }

    public class BeforeAnswer{
        private String inputText;
        private String answerText;

        public String getInputText() {
            return inputText;
        }

        public String getAnswerText() {
            return answerText;
        }

        public void setInputText(String inputText) {
            this.inputText = inputText;
        }

        public void setAnswerText(String answerText) {
            this.answerText = answerText;
        }
    }
}
