package com.ots.voteservice.dto;

import com.ots.voteservice.entity.Answer;

public class AnswerDto {

    private String answerName;
    private int count;

    public AnswerDto() {
    }

    public AnswerDto(String answerName, int count) {
        this.answerName = answerName;
        this.count = count;
    }

    public Answer toEntity(AnswerDto answerDto) {
        Answer answer = new Answer();
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerDto answerDto = (AnswerDto) o;

        if (count != answerDto.count) return false;
        return answerName != null ? answerName.equals(answerDto.answerName) : answerDto.answerName == null;
    }

    @Override
    public int hashCode() {
        int result = answerName != null ? answerName.hashCode() : 0;
        result = 31 * result + count;
        return result;
    }
}
