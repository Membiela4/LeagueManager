package com.example.leaguemanager2.test;

import com.example.leaguemanager2.dao.MatchDAO;
import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Match;

import java.sql.SQLException;
import java.util.List;

public class Test2 {
    //Testing functions of MatchDAO
    public static void main(String[] args) throws SQLException {

        insertMatch(); //no inserta partidos en bbdd pero si que los crea

        findALl();

        findTeamMatchs();

    }

    public static void insertMatch() {
        MatchDAO matchDAO = new MatchDAO();
        TeamDAO teamDAO = new TeamDAO();
        try{
            Match m = new Match(2,teamDAO.findByName("Madrid"),teamDAO.findByName("Barca"),2);
            matchDAO.save(m);
            System.out.println(m);
        }catch(SQLException e) {

        }
    }

    public static void findALl() throws SQLException {
        MatchDAO matchDAO = new MatchDAO();
        TeamDAO teamDAO = new TeamDAO();
        List<Match> matches =matchDAO.findAll();

        for (Match m: matches) {
            System.out.println(m);

        }
    }


    public static void findTeamMatchs() throws SQLException {

        MatchDAO matchDAO = new MatchDAO();
        TeamDAO teamDAO = new TeamDAO();
        List<Match> m2 = matchDAO.findByTeam(teamDAO.findByName("Madrid").getTeam_id());

        for (Match m: m2) {
            System.out.println(m);

        }
    }

}
