package com.ots.voteservice.dto;

import java.util.List;

public class VotingDto {
    private String votingTheme;
    private String question;
    private List<AnswerDto> answerList;


    public VotingDto() {
    }

    public String getVotingTheme() {
        return votingTheme;
    }

    public void setVotingTheme(String votingTheme) {
        this.votingTheme = votingTheme;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerDto> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<AnswerDto> answerList) {
        this.answerList = answerList;
    }
}
