package com.ots.voteservice.controller;

import com.ots.voteservice.entity.Voting;
import com.ots.voteservice.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UiController {

    @Autowired
    private VotingService votingService;


    @GetMapping(value = "/voting/{votingId}")
    public ModelAndView getHomePage21333(@PathVariable int votingId) {

        Voting voting = votingService.getVotingById(votingId);

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "hello my dear friend");
        mav.addObject("voting", voting);
        mav.setViewName("show");
        return mav;
    }

    @PostMapping(value = "/voting/answers")
    public String getHomePage21d333(@RequestParam(name = "selectedAnswersId") List selectedAnswersId,
                                    @RequestParam(name = "votingId") String votingId) {
        System.out.println("enter to log, that have a request!");
        votingService.setVotes(selectedAnswersId, votingId);
        return "redirect:/voting/" + votingId;
    }


}
