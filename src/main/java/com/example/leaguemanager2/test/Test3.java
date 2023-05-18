package com.example.leaguemanager2.test;

import com.example.leaguemanager2.dao.MatchDAO;
import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Calendar;
import com.example.leaguemanager2.modelDomain.Match;
import com.example.leaguemanager2.modelDomain.Team;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;



public class Test3 {
    //test to create a calendar with all matchs

    Calendar calendar;
    TeamDAO teamDAO;
    MatchDAO matchDAO;
    List<Team> teams;
        @BeforeClass
        void setUp() throws SQLException {
            calendar = new Calendar();
            teamDAO = new TeamDAO();
            matchDAO = new MatchDAO();
            teams = teamDAO.findAll();
        }



        List<Match> matchs= calendar.createCalendar(teams);
        @Test
        void testCalendar() throws SQLException {
            for (Match m: matchs) {
                System.out.println(m);


            }
    }







}
