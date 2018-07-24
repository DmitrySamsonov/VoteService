package com.ots.voteservice.service;

import com.ots.voteservice.dto.AnswerDto;
import com.ots.voteservice.dto.VotingDto;
import com.ots.voteservice.entity.Answer;
import com.ots.voteservice.entity.Voting;
import com.ots.voteservice.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VotingService {


    @Autowired
    private VotingRepository votingRepository;


    public String createVoting(VotingDto votingDto) {
        //TODO: здесь будет еще проверка на валидность входных данных


        Voting voting = new VotingDto().toEntity(votingDto);
        Voting savedVoting = votingRepository.save(voting);

        String link = "http://localhost:8090/rest/voting/" + savedVoting.getVotingId();
        savedVoting.setLink(link);
        votingRepository.save(savedVoting);
        return link;
    }


    public VotingDto getVotingById(int votingId) {
        //TODO: проверка на валидность id

        Optional<Voting> voting = votingRepository.findById(votingId);
        VotingDto votingDto = new VotingDto().toDto(voting);

        return votingDto;
    }

    public int getIdByLink(String link){
        Voting findedVoting = votingRepository.findByLink(link);
        return findedVoting.getVotingId();
    }

    public void startVoting(int votingId) {
        changeOpenValueInVoting(votingId, true);
    }

    public void stopVoting(int votingId) {
        changeOpenValueInVoting(votingId, false);
    }

    private void changeOpenValueInVoting(int votingId, boolean isOpen) {
        Optional<Voting> findedVoting = votingRepository.findById(votingId);
        Voting voting = findedVoting.get();
        if (voting != null) {
            voting.setOpen(isOpen);
            votingRepository.save(voting);
        }
    }

    public void setVotes(List<AnswerDto> answerDtoList, int votingId) {
        Optional<Voting> findedVoting = votingRepository.findById(votingId);
        Voting voting = findedVoting.get();
        List<Answer> selectedAnswers = new ArrayList();
        for (AnswerDto answerDto : answerDtoList) {
            selectedAnswers.add(new AnswerDto().toEntity(answerDto));
        }
        for (int i = 0; i < voting.getAnswers().size(); i++) {
            Answer answerInVoting = voting.getAnswers().get(i);
            for (Answer selectedAnswer : selectedAnswers) {
                if (answerInVoting.getAnswerName().equals(selectedAnswer.getAnswerName())) {
                    answerInVoting.setCount(answerInVoting.getCount() + 1);
                }
            }
        }

    }
}
