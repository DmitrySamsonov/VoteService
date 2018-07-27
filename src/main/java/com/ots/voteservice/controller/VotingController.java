package com.ots.voteservice.controller;

import com.ots.voteservice.dto.VotingDto;
import com.ots.voteservice.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/rest")
public class VotingController {

    @Autowired
    private VotingService votingService;


    @PostMapping(value = "/voting/create")
    @ResponseStatus(HttpStatus.CREATED)
    public int createVoting(@RequestBody VotingDto votingDto) {
        return votingService.createVoting(votingDto);
    }

    @GetMapping(value = "/voting/{votingId}/start")
    @ResponseStatus(HttpStatus.OK)
    public String startVotingAndGenerateLink(@PathVariable int votingId) {
        return  votingService.startVotingAndGenerateLink(votingId);
    }

    @GetMapping(value = "/voting/{votingId}/stop")
    @ResponseStatus(HttpStatus.OK)
    public void stopVoting(@PathVariable int votingId) {
        votingService.stopVoting(votingId);
    }

    @GetMapping(value = "/voting/{votingId}")
    public VotingDto getVotingStatistic(@PathVariable int votingId) {
        return votingService.getVotingStatisticForRest(votingId);
    }

    @GetMapping(value = "/voting/{votingId}/{answerId}")
    public int getAnswerStatistic(@PathVariable int votingId, @PathVariable int answerId) {
        return votingService.getAnswerStatisticByAnswerId(votingId, answerId);
    }

    @PostMapping(value = "/voting/{votingId}/answers")
    @ResponseStatus(HttpStatus.OK)
    public void setSelectedAnswers(@PathVariable int votingId, @RequestParam(name = "selectedAnswersId") List selectedAnswersId) {
        votingService.setSelectedAnswers(selectedAnswersId, votingId);
    }


}
