package com.ots.voteservice.dto;

import com.ots.voteservice.entity.Answer;
import com.ots.voteservice.entity.Voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VotingDto {
    private String votingTheme;
    private String question;
    private List<AnswerDto> answerList;

    public VotingDto() {
    }

    public Voting toEntity(VotingDto votingDto) {
        Voting voting = new Voting();

        //TODO: посмотри еще что с ID шником делать
        voting.setVotingTheme(votingDto.getVotingTheme());
        voting.setQuestion(votingDto.getQuestion());
        List<Answer> answers = new ArrayList<>();
        for (AnswerDto answerDto : votingDto.answerList) {
            answers.add(new AnswerDto().toEntity(answerDto));
        }
        voting.setAnswers(answers);

        return voting;
    }


    public VotingDto toDto(Optional<Voting> voting) {
        VotingDto votingDto = new VotingDto();

        //TODO: проверка на id (есть - заполняем, нету - оставляем)
        Voting votingObj = voting.get();
        votingDto.setVotingTheme(votingObj.getVotingTheme());
        votingDto.setQuestion(votingObj.getQuestion());
        List<AnswerDto> answerDtoList = new ArrayList<>();
        for (Answer answer : votingObj.getAnswers()) {
            answerDtoList.add(new AnswerDto().toDto(answer));
        }
        votingDto.setAnswerList(answerDtoList);
        return votingDto;
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
