package com.example.leaguemanager2.test;

import com.example.leaguemanager2.dao.PlayerDAO;
import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Player;
import com.example.leaguemanager2.modelDomain.Team;

import java.sql.SQLException;
import java.util.List;

public class Test1 {

    public static void main(String[] args) throws SQLException {
        PlayerDAO playerDAO =new PlayerDAO();
        TeamDAO teamDAO = new TeamDAO();
        /*TEST CREAR EQUIPO
        Team t = new Team();
        t.setName("Madrid");
        t.setAbbreviation("RMA");
        t.setIcon(null);
        t.setPlayers(null);
        teamDAO.save(t);

        Team t2 = new Team();
        t2.setName("Barca");
        t2.setAbbreviation("FCB");
        t2.setIcon(null);
        t2.setPlayers(null);
        //teamDAO.save(t2);
         /*
         */

        List<Team> teams = teamDAO.findAll();


        List<Player> allPlayers = playerDAO.findAll();

        for (Player p:
             allPlayers) {
            //System.out.println(p);
        }

        //TEST CREAR JUGADOR(FALLO AL ASIGNAR EL TEAM ID)
        Player p = new Player();
        p.setName("Cristiano");
        p.setLastName("Ronaldo");
        p.setAlias("CR7");
        p.setDorsal(7);
        p.setTeam(teamDAO.findByName("Madrid"));
        //playerDAO.save(p);

        Player p2 = new Player();
        p2.setName("Lionel");
        p2.setLastName("Messi");
        p2.setAlias("Messi");
        p2.setDorsal(10);
        p2.setTeam(teamDAO.findByName("Barca"));
        //playerDAO.save(p2);

        for (Team team:
                teams) {
            System.out.println(team);
        }




    }
}
