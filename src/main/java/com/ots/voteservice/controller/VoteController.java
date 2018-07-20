package com.ots.voteservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class VoteController {

    @RequestMapping("/")
    public String testController() {
        return "nothing";
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
