package com.ots.voteservice.dto;

import java.util.List;

public class InputBlockDto {
    private String questionName;
    private String type;
    private List<Object> elements;





    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getElements() {
        return elements;
    }

    public void setElements(List<Object> elements) {
        this.elements = elements;
    }
}
