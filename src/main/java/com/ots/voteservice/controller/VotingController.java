package com.ots.voteservice.controller;

import com.ots.voteservice.dto.VotingDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class VotingController {

    @RequestMapping(value = "/")
    public String testController() {
        return "nothing";
    }


    private VotingDto votingDtoSend;

    @PostMapping(value = "/voting/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createVoting(@RequestBody VotingDto votingDto) {
        System.out.println("enter to log, that have a request!");
        votingDtoSend = votingDto;
        return "http://localhost:8090/voting/votingId";
    }


    @GetMapping(value = "/voting/votingId")
    public VotingDto getVotingStatistic() {
        System.out.println("enter to log, that have a request!");
        return votingDtoSend;
    }

    @GetMapping(value = "/home")
    public String getHomePage() {
        System.out.println("enter to log, that have a request!");
        return "index";
    }

    @PostMapping(value = "/voting/votingId2")
    public VotingDto setVote(@RequestParam("voteText") String voteText ) {
        System.out.println("enter to log, that have a request!");

//        Map<String, Integer> map = votingDtoSend.getVoteList();
//        map.put(voteText, map.get(voteText) + 1);
        return votingDtoSend;
    }







    @RequestMapping("/mydb")
    public String testController2() {

        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~edaDB", "test", "test");
            Statement st = conn.createStatement();
            st.execute("create TABLE pawn(name VARCHAR(20))");
            System.out.println("table create successfullt");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return "result";
    }

}
