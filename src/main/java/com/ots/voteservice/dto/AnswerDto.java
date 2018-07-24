package com.ots.voteservice.dto;

import com.ots.voteservice.entity.Answer;

public class AnswerDto {

    private String answerName;
    private int count;

    public AnswerDto() {
    }

    public Answer toEntity(AnswerDto answerDto) {
        Answer answer = new Answer();

        //TODO: посмотри еще что с ID шником делать
        answer.setAnswerName(answerDto.getAnswerName());
        answer.setCount(answerDto.getCount());
        return answer;
    }


    public AnswerDto toDto(Answer answer) {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerName(answer.getAnswerName());
        answerDto.setCount(answer.getCount());
        return answerDto;
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
