package com.ots.voteservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoteController {

    @RequestMapping
    public void testController() {
        System.out.println("hello");
    }

}
