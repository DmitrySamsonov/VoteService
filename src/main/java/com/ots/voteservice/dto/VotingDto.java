package com.ots.voteservice.dto;

import com.ots.voteservice.entity.Answer;
import com.ots.voteservice.entity.Voting;

import java.util.ArrayList;
import java.util.List;

public class VotingDto {
    private String votingTheme;
    private String question;
    private List<AnswerDto> answerList;

    public VotingDto() {
    }

    public VotingDto(String votingTheme, String question, List<AnswerDto> answerList) {
        this.votingTheme = votingTheme;
        this.question = question;
        this.answerList = answerList;
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


    public VotingDto toDto(Voting voting) {
        VotingDto votingDto = new VotingDto();

        //TODO: проверка на id (есть - заполняем, нету - оставляем)
        votingDto.setVotingTheme(voting.getVotingTheme());
        votingDto.setQuestion(voting.getQuestion());
        List<AnswerDto> answerDtoList = new ArrayList<>();
        for (Answer answer : voting.getAnswers()) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotingDto votingDto = (VotingDto) o;

        if (votingTheme != null ? !votingTheme.equals(votingDto.votingTheme) : votingDto.votingTheme != null)
            return false;
        if (question != null ? !question.equals(votingDto.question) : votingDto.question != null) return false;

        if(answerList != null){
            if(votingDto.answerList != null){
                for(int i = 0; i < answerList.size(); i++){
                    if(!votingDto.answerList.get(i).equals(answerList.get(i))){
                        return false;
                    }
                }

            }
        }else{
            if(votingDto.answerList != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = votingTheme != null ? votingTheme.hashCode() : 0;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (answerList != null ? answerList.hashCode() : 0);
        return result;
    }
}
