package com.ots.voteservice.dto;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingDtoTest {

    @Test
    public void equalsTest(){
        String votingTheme = "food";
        String question = "what to it?";
        List<AnswerDto> answerList = new ArrayList<>();
        AnswerDto answerDto1 = new AnswerDto("apple", 0);
        AnswerDto answerDto2 = new AnswerDto("banana", 0);
        answerList.add(answerDto1);
        answerList.add(answerDto2);
        VotingDto votingDto = new VotingDto(votingTheme, question, answerList);


        String votingTheme2 = "food";
        String question2 = "what to it?";
        List<AnswerDto> answerList2 = new ArrayList<>();
        AnswerDto answerDto3 = new AnswerDto("apple", 0);
        AnswerDto answerDto4 = new AnswerDto("banana", 0);
        answerList2.add(answerDto3);
        answerList2.add(answerDto4);
        VotingDto votingDto2 = new VotingDto(votingTheme2, question2, answerList2);

        boolean result = votingDto.equals(votingDto2);
        assertTrue(result);
    }
}
