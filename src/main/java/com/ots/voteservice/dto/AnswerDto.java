package com.ots.voteservice.dto;

public class AnswerDto {

    String answerName;
    int count;

    public AnswerDto() {
    }

      public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
