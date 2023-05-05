package com.example.leaguemanager2.test;

import com.example.leaguemanager2.dao.PlayerDAO;
import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Player;

import java.sql.SQLException;

public class Test1 {

    public static void main(String[] args) throws SQLException {
        PlayerDAO playerDAO =new PlayerDAO();
        TeamDAO teamDAO = new TeamDAO();
        Player p = new Player();
        p.setName("Cristiano");
        p.setLastName("Ronaldo");
        p.setAlias("CR7");
        p.setDorsal(7);
        playerDAO.save(p);
    }
}
