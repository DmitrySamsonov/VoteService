package com.ots.voteservice.service;

import com.ots.voteservice.dto.VotingDto;
import com.ots.voteservice.entity.Answer;
import com.ots.voteservice.entity.Voting;
import com.ots.voteservice.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VotingService {


    @Autowired
    private VotingRepository votingRepository;


    public int createVoting(VotingDto votingDto) {
        //TODO: здесь будет еще проверка на валидность входных данных


        Voting voting = new VotingDto().toEntity(votingDto);
        Voting savedVoting = votingRepository.save(voting);

        String link = "http://localhost:8090/voting/" + savedVoting.getVotingId();
        savedVoting.setLink(link);
        votingRepository.save(savedVoting);
        return savedVoting.getVotingId();
    }

    public Voting getVotingById(int votingId) {
        //TODO: проверка на валидность id
        Optional<Voting> voting = votingRepository.findById(votingId);
        return voting.get();
    }

    public VotingDto getVotingDtoById(int votingId) {
        //TODO: проверка на валидность id
        Voting voting = getVotingById(votingId);
        VotingDto votingDto = new VotingDto().toDto(voting);
        return votingDto;
    }

    public String getLinkByVotingId(int id) {
        Optional<Voting> findedVoting = votingRepository.findByVotingId(id);
        return findedVoting.get().getLink();
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

    public void setVotes(List<String> selectedAnswersId, String votingId) {
        int votingIdInt = Integer.valueOf(votingId);
        Optional<Voting> findedVoting = votingRepository.findByVotingId(votingIdInt);
        Voting voting = findedVoting.get();
        List<Answer> answers = voting.getAnswers();
        List<Integer> selectedAnswersIdInt =
                selectedAnswersId.stream().map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < answers.size(); i++) {
            for (int selectedAnswerId : selectedAnswersIdInt) {
                if (answers.get(i).getAnswerId() == selectedAnswerId && voting.isOpen()) {
                    int count = answers.get(i).getCount();
                    answers.get(i).setCount(count + 1);
                }
            }
        }
        votingRepository.save(voting);
    }

//    public void setVotes(List<AnswerDto> answerDtoList, int votingId) {
//        Optional<Voting> findedVoting = votingRepository.findById(votingId);
//        Voting voting = findedVoting.get();
//        List<Answer> selectedAnswers = new ArrayList();
//        for (AnswerDto answerDto : answerDtoList) {
//            selectedAnswers.add(new AnswerDto().toEntity(answerDto));
//        }
//        for (int i = 0; i < voting.getAnswers().size(); i++) {
//            Answer answerInVoting = voting.getAnswers().get(i);
//            for (Answer selectedAnswer : selectedAnswers) {
//                if (answerInVoting.getAnswerName().equals(selectedAnswer.getAnswerName())) {
//                    answerInVoting.setCount(answerInVoting.getCount() + 1);
//                }
//            }
//        }
//
//    }
}
