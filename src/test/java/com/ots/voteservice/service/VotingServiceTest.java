package com.ots.voteservice.service;

import com.ots.voteservice.dto.AnswerDto;
import com.ots.voteservice.dto.VotingDto;
import com.ots.voteservice.entity.Answer;
import com.ots.voteservice.entity.Voting;
import com.ots.voteservice.repository.VotingRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingServiceTest {

    @Autowired
    private VotingService votingService;

    @Autowired
    private VotingRepository votingRepository;

    @Before
    public void clearBefore() {
        clearDatabase();
    }

    @After
    public void clearAfter() {
        clearDatabase();
    }

    @Test
    public void clearDatabase() {
        votingRepository.deleteAll();
    }

    @Test
    public void saveVoting() {
        String votingTheme = "food";
        String question = "whay your favourite fruits?";
        Answer answer1 = new Answer("apple", 0);
        Answer answer2 = new Answer("orange", 0);
        List<Answer> answers = new ArrayList<Answer>();
        answers.add(answer1);
        answers.add(answer2);
        String link = "";
        boolean isOpen = false;

        Voting voting = new Voting(votingTheme, question, answers, link, isOpen);

        votingRepository.save(voting);

        List<Voting> results = (List<Voting>) votingRepository.findAll();

        assertEquals(results.size(), 1);
        assertEquals(results.get(0), voting);

        clearDatabase();
    }


    @Test
    public void createVoting() {

        String votingTheme = "food";
        String question = "what to it?";
        List<AnswerDto> answerList = new ArrayList<>();
        AnswerDto answerDto1 = new AnswerDto("apple", 0);
        AnswerDto answerDto2 = new AnswerDto("banana", 0);
        answerList.add(answerDto1);
        answerList.add(answerDto2);
        VotingDto votingDto = new VotingDto(votingTheme, question, answerList);

        int id = votingService.createVoting(votingDto);
        assertEquals(isInteger(id), true);
        assertEquals(id > 0, true);

        clearDatabase();
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


    @Test
    public void getVotingById() {
        String votingTheme = "food";
        String question = "what to it?";
        List<Answer> answerList = new ArrayList<>();
        Answer answer1 = new Answer("apple", 0);
        Answer answer2 = new Answer("banana", 0);
        answerList.add(answer1);
        answerList.add(answer2);
        String link = "";
        boolean isOpen = false;
        Voting voting = new Voting(votingTheme, question, answerList, link, isOpen);

        Voting savedVoting = votingRepository.save(voting);

        Voting foundedVoting = votingService.getVotingStatisticForUserInterface(savedVoting.getVotingId());

        assertEquals(savedVoting, foundedVoting);

        clearDatabase();
    }


    @Test
    public void getVotingDtoById() {
        String votingTheme = "food";
        String question = "what to it?";
        List<Answer> answerList = new ArrayList<>();
        Answer answer1 = new Answer("apple", 0);
        Answer answer2 = new Answer("banana", 0);
        answerList.add(answer1);
        answerList.add(answer2);
        String link = "";
        boolean isOpen = false;
        Voting voting = new Voting(votingTheme, question, answerList, link, isOpen);

        Voting savedVoting = votingRepository.save(voting);
        VotingDto votingDto = new VotingDto().toDto(voting);

        VotingDto foundedVotingDto = votingService.getVotingStatisticForRest(savedVoting.getVotingId());


        assertEquals(votingDto, foundedVotingDto);

        clearDatabase();
    }


    @Test
    public void startVoting() {
        String votingTheme = "food";
        String question = "what to it?";
        List<Answer> answerList = new ArrayList<>();
        Answer answer1 = new Answer("apple", 0);
        Answer answer2 = new Answer("banana", 0);
        answerList.add(answer1);
        answerList.add(answer2);
        String link = "http://localhost:8090/voting/1";
        boolean isOpen = false;
        Voting voting = new Voting(votingTheme, question, answerList, link, isOpen);

        Voting savedVoting = votingRepository.save(voting);

        votingService.startVotingAndGenerateLink(savedVoting.getVotingId());

        Optional<Voting> foundedVoting = votingRepository.findByVotingId(savedVoting.getVotingId());


        assertEquals(foundedVoting.get().isOpen(), true);

        clearDatabase();
    }

    @Test
    public void stopVoting() {
        String votingTheme = "food";
        String question = "what to it?";
        List<Answer> answerList = new ArrayList<>();
        Answer answer1 = new Answer("apple", 0);
        Answer answer2 = new Answer("banana", 0);
        answerList.add(answer1);
        answerList.add(answer2);
        String link = "http://localhost:8090/voting/1";
        boolean isOpen = false;
        Voting voting = new Voting(votingTheme, question, answerList, link, isOpen);

        Voting savedVoting = votingRepository.save(voting);

        votingService.stopVoting(savedVoting.getVotingId());

        Optional<Voting> foundedVoting = votingRepository.findByVotingId(savedVoting.getVotingId());


        assertEquals(foundedVoting.get().isOpen(), false);

        clearDatabase();
    }

    @Test
    public void setVotesIsOpen() {
        String votingTheme = "food";
        String question = "what to it?";
        List<Answer> answerList = new ArrayList<>();
        Answer answer1 = new Answer("apple", 0);
        Answer answer2 = new Answer("banana", 0);
        answerList.add(answer1);
        answerList.add(answer2);
        String link = "http://localhost:8090/voting/1";
        boolean isOpen = true;
        Voting voting = new Voting(votingTheme, question, answerList, link, isOpen);

        Voting savedVoting = votingRepository.save(voting);

        List<String> selectedAnswerId = new ArrayList<>();
        selectedAnswerId.add(String.valueOf(savedVoting.getAnswers().get(0).getAnswerId()));
        selectedAnswerId.add(String.valueOf(savedVoting.getAnswers().get(1).getAnswerId()));

        votingService.setSelectedAnswers(selectedAnswerId, savedVoting.getVotingId());

        Optional<Voting> foundedVoting = votingRepository.findByVotingId(savedVoting.getVotingId());

        assertEquals(foundedVoting.get().getAnswers().get(0).getCount(), 1);
        assertEquals(foundedVoting.get().getAnswers().get(1).getCount(), 1);


        clearDatabase();
    }

    @Test
    public void setVotesIsClosed() {
        String votingTheme = "food";
        String question = "what to it?";
        List<Answer> answerList = new ArrayList<>();
        Answer answer1 = new Answer("apple", 0);
        Answer answer2 = new Answer("banana", 0);
        answerList.add(answer1);
        answerList.add(answer2);
        String link = "http://localhost:8090/voting/1";
        boolean isOpen = false;
        Voting voting = new Voting(votingTheme, question, answerList, link, isOpen);

        Voting savedVoting = votingRepository.save(voting);

        List<String> selectedAnswerId = new ArrayList<>();
        selectedAnswerId.add(String.valueOf(savedVoting.getAnswers().get(0).getAnswerId()));
        selectedAnswerId.add(String.valueOf(savedVoting.getAnswers().get(1).getAnswerId()));

        votingService.setSelectedAnswers(selectedAnswerId, savedVoting.getVotingId());

        Optional<Voting> foundedVoting = votingRepository.findByVotingId(savedVoting.getVotingId());

        assertEquals(foundedVoting.get().getAnswers().get(0).getCount(), 0);
        assertEquals(foundedVoting.get().getAnswers().get(1).getCount(), 0);


        clearDatabase();
    }

}
