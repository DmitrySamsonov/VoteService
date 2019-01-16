package com.ots.voteservice.controller;

import com.ots.voteservice.dto.InputBlockDto;
import com.ots.voteservice.dto.MyDto;
import com.ots.voteservice.dto.VotingDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class MyController {

    @PostMapping(value = "/test/mydto")
    public void testMydto(@RequestBody MyDto myDto) {

        System.out.println("testMydto");

    }


    @PostMapping(value = "/test/inputblockdto")
    public void testInputBlockDto(@RequestBody InputBlockDto inputBlockDto) {

        System.out.println("testInputBlockDto");

    }


    @GetMapping(value = "/test")
    public void connect() {

        System.out.println("connect");

    }

}
