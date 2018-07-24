package com.ots.voteservice.controller;

import com.ots.voteservice.dto.AnswerDto;
import com.ots.voteservice.dto.VotingDto;
import com.ots.voteservice.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/rest")
public class VotingController {

    @Autowired
    private VotingService votingService;


    @PostMapping(value = "/voting/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createVoting(@RequestBody VotingDto votingDto) {
        System.out.println("enter to log, that have a request!");
        return votingService.createVoting(votingDto);
    }

    @GetMapping(value = "/voting/{votingId}/id")
    public String getIdByLink(@RequestParam(name = "link") String link) {
        System.out.println("enter to log, that have a request!");
        return String.valueOf(votingService.getIdByLink(link));
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


    @GetMapping(value = "/voting/{votingId}")
    public VotingDto getVotingStatistic(@PathVariable int votingId) {
        System.out.println("enter to log, that have a request!");
        return votingService.getVotingById(votingId);
    }




    @PostMapping(value = "/voting/{votingId}")
    @ResponseStatus(HttpStatus.OK)
    public void setVotes(@RequestBody List<AnswerDto> answerDtoList, @PathVariable int votingId) {
        System.out.println("enter to log, that have a request!");
        votingService.setVotes(answerDtoList, votingId);
    }





//    @GetMapping(value = "/home")
//    public ModelAndView getHomePage() {
//        System.out.println("enter to log, that have a request!");
//
//        ModelAndView mav = new ModelAndView("/index");
////        mav.addObject("foos", fooService.getFoos());
//        return mav;
//    }
}
