package com.ots.voteservice.controller;

import com.ots.voteservice.entity.Voting;
import com.ots.voteservice.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UiController {

    @Autowired
    private VotingService votingService;


    @GetMapping(value = "/rest/voting/{votingId}/ui")
    public ModelAndView getHomePage21333(@PathVariable int votingId) {
        Voting voting = votingService.getVotingStatisticForUserInterface(votingId);

        ModelAndView mav = new ModelAndView();
        mav.addObject("voting", voting);
        mav.setViewName("show");
        return mav;
    }

    @PostMapping(value = "/rest/voting/{votingId}/answers/ui")
    public String setSelectedVotes(@PathVariable int votingId, @RequestParam(name = "selectedAnswersId") List selectedAnswersId) {
        votingService.setSelectedAnswers(selectedAnswersId, votingId);
        return "redirect:/rest/voting/" + votingId + "/ui";
    }





}
