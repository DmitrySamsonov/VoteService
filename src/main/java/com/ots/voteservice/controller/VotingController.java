package com.ots.voteservice.controller;

import com.ots.voteservice.dto.VotingDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@CrossOrigin
public class VotingController {

    @RequestMapping(value = "/")
    public String testController() {
        return "nothing";
    }



    @PostMapping(value = "/voting/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVoting(@RequestBody VotingDto votingDto) {
        System.out.println("enter to log, that have a request!");
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
