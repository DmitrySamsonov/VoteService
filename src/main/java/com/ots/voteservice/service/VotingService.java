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

    public String startVotingAndGenerateLink(int votingId) {
        changeOpenValueInVoting(votingId, true);
        return generateLinkByVotingId(votingId);
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

    private String generateLinkByVotingId(int votingId) {

        Optional<Voting> findedVoting = votingRepository.findByVotingId(votingId);

        String link = "http://localhost:8090/rest/voting/" + votingId;
        findedVoting.get().setLink(link);

        return link;
    }

    public Voting getVotingStatisticForUserInterface(int votingId) {
        if (!isInteger(votingId)) {
            throw new IllegalArgumentException("votingId is not valid.");
        }
        Optional<Voting> voting = votingRepository.findById(votingId);
        return voting.get();
    }

    public VotingDto getVotingStatisticForRest(int votingId) {
        if (!isInteger(votingId)) {
            throw new IllegalArgumentException("votingId is not valid.");
        }
        Voting voting = getVotingStatisticForUserInterface(votingId);
        VotingDto votingDto = new VotingDto().toDto(voting);
        return votingDto;
    }

    public int getAnswerStatisticByAnswerId(int votingId, int answerId) {
        Optional<Voting> findedVoting = votingRepository.findByVotingId(votingId);
        List<Answer> answers = findedVoting.get().getAnswers();
        for (Answer answer : answers) {
            if (answer.getAnswerId() == answerId) {
                return answer.getCount();
            }
        }
        return 0;
    }

    public void setSelectedAnswers(List<String> selectedAnswersId, int votingId) {
        Optional<Voting> findedVoting = votingRepository.findByVotingId(votingId);
        Voting voting = findedVoting.get();

        List<Answer> answers = voting.getAnswers();

        List<Integer> selectedAnswersIdInt = convertListStringToListInteger(selectedAnswersId);

        for (Answer answer : answers) {
            for (int selectedAnswerId : selectedAnswersIdInt) {
                if (answer.getAnswerId() == selectedAnswerId && voting.isOpen()) {
                    int count = answer.getCount();
                    answer.setCount(count + 1);
                }
            }
        }

        votingRepository.save(voting);
    }


    private List<Integer> convertListStringToListInteger(List<String> selectedAnswersId) {
        return selectedAnswersId.stream().map(Integer::parseInt).collect(Collectors.toList());
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
