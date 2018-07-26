package com.ots.voteservice.entity;


import com.ots.voteservice.dto.AnswerDto;
import com.ots.voteservice.dto.VotingDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingTest {

    @Test
    public void equalsTest(){
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


        String votingTheme2 = "food";
        String question2 = "whay your favourite fruits?";
        Answer answer3 = new Answer("apple", 0);
        Answer answer4 = new Answer("orange", 0);
        List<Answer> answers2 = new ArrayList<Answer>();
        answers2.add(answer3);
        answers2.add(answer4);
        String link2 = "";
        boolean isOpen2 = false;

        Voting voting2 = new Voting(votingTheme2, question2, answers2, link2, isOpen2);

        boolean result = voting.equals(voting2);
        assertTrue(result);
    }
}
