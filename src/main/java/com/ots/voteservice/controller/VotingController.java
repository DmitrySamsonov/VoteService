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
        System.out.println("enter to log, that have a request!");
        return votingService.createVoting(votingDto);
    }

    @GetMapping(value = "/voting/{votingId}/start")
    @ResponseStatus(HttpStatus.OK)
    public void startVoting(@PathVariable int votingId) {
        System.out.println("enter to log, that have a request!");
        votingService.startVoting(votingId);
    }

    @GetMapping(value = "/voting/{votingId}/stop")
    @ResponseStatus(HttpStatus.OK)
    public void stopVoting(@PathVariable int votingId) {
        System.out.println("enter to log, that have a request!");
        votingService.stopVoting(votingId);
    }

    @GetMapping(value = "/voting/{votingId}/link")
    public String getLinkById(@PathVariable int votingId) {
        System.out.println("enter to log, that have a request!");
        return votingService.getLinkByVotingId(votingId);
    }

    @GetMapping(value = "/voting/{votingId}")
    public VotingDto getVotingStatistic(@PathVariable int votingId) {
        System.out.println("enter to log, that have a request!");
        return votingService.getVotingDtoById(votingId);
    }


    @PostMapping(value = "/voting/answers")
    @ResponseStatus(HttpStatus.OK)
    public void getHomePage21d333(@RequestParam(name = "selectedAnswersId") List selectedAnswersId,
                                  @RequestParam(name = "votingId") String votingId) {
        System.out.println("enter to log, that have a request!");
        votingService.setVotes(selectedAnswersId, votingId);
    }

}
