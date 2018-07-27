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
        checkVotingDto(votingDto);

        Voting voting = new VotingDto().toEntity(votingDto);
        Voting savedVoting = votingRepository.save(voting);

        String link = "http://localhost:8090/voting/" + savedVoting.getVotingId();
        savedVoting.setLink(link);
        votingRepository.save(savedVoting);
        return savedVoting.getVotingId();
    }

    public Voting getVotingById(int votingId) {
        if (!isInteger(votingId)) {
            throw new IllegalArgumentException("votingId is not valid.");
        }
        Optional<Voting> voting = votingRepository.findById(votingId);
        return voting.get();
    }

    public VotingDto getVotingDtoById(int votingId) {
        if (!isInteger(votingId)) {
            throw new IllegalArgumentException("votingId is not valid.");
        }
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


    private void checkVotingDto(VotingDto votingDto) {
        if (votingDto != null) {
            List answers = votingDto.getAnswerList();
            if (answers.size() == 0) {
                throw new IllegalArgumentException("voting without answers");
            }
        }
    }

    private boolean isInteger(int x) {
        try {
            if (x == (int) x) {
                // Number is integer
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
