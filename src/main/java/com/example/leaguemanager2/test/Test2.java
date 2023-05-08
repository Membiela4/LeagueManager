package com.example.leaguemanager2.test;

import com.example.leaguemanager2.dao.MatchDAO;
import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Match;

import java.sql.SQLException;

public class Test2 {
    public static void main(String[] args) {


        MatchDAO matchDAO = new MatchDAO();
        TeamDAO teamDAO = new TeamDAO();
        try{
            Match m = new Match(teamDAO.findByName("Madrid"),teamDAO.findByName("Barca"),1);
            System.out.println(m);
        }catch(SQLException e){

        }


    }


}
