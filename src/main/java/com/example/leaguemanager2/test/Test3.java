package com.example.leaguemanager2.test;

import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Calendar;
import com.example.leaguemanager2.modelDomain.Team;

import java.sql.SQLException;
import java.util.List;

public class Test3 {
     public static Calendar calendar;
    static TeamDAO teamDAO = new TeamDAO();


    public static void main(String[] args) throws SQLException {
        List<Team> teams = teamDAO.findAll();
        calendar.createCalendar(teams);
    }
}
