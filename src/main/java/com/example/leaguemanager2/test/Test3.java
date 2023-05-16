package com.example.leaguemanager2.test;

import com.example.leaguemanager2.dao.MatchDAO;
import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Calendar;
import com.example.leaguemanager2.modelDomain.Match;
import com.example.leaguemanager2.modelDomain.Team;

import java.sql.SQLException;
import java.util.List;



public class Test3 {
    //test to create a calendar with all matchs
    public static void main(String[] args) throws SQLException {

        Calendar calendar = new Calendar();
        TeamDAO teamDAO = new TeamDAO();
        MatchDAO matchDAO = new MatchDAO();

        List<Team> teams = teamDAO.findAll();
        List<Match> matchs= calendar.createCalendar(teams);



        for (Match m:
             matchs) {
            matchDAO.save(m);
            System.out.println(m);
        }





    }
}
