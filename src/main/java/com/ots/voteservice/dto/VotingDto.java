package com.ots.voteservice.dto;

import java.util.Map;

public class VotingDto {
    private String themeName;
    private String question;
    private Map<String, Integer> voteList;


    public VotingDto() {
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<String, Integer> getVoteList() {
        return voteList;
    }

    public void setVoteList(Map<String, Integer> voteList) {
        this.voteList = voteList;
    }
}
