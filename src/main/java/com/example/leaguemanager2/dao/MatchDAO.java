package com.example.leaguemanager2.dao;

import com.example.leaguemanager2.modelDomain.Match;
import com.example.leaguemanager2.modelDomain.Team;
import com.example.leaguemanager2.utils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatchDAO  {
    private final static String FINDALL = "select * from match";
    private final static String FINDBYID = "select * from match where match_id = ?";
    private final static String DELETE = "delete from match where match_id = ?";
    private final static String UPDATE = "update match set name = ?,team_id =?, abbreviation = ?,icon = ?,num_players = ?, where team_id = ?";
    private final static String INSERT = "insert into match(match_id,local_id,visitor_id,day) values(?,?,?,?)";

    private Connection connection;
    public MatchDAO() {this.connection = Connect.getConnect();}

    public MatchDAO(Connection connection) {this.connection = connection;}
    private PlayerDAO playerDAO = new PlayerDAO();
    private TeamDAO teamDAO = new TeamDAO();

    public List findAll() throws SQLException {
        List<Match> matchs = new ArrayList<>();

        try(PreparedStatement pst = this.connection.prepareStatement(FINDALL)){

            try(ResultSet resultSet = pst.executeQuery()) {

                while(resultSet.next()) {
                    Match m = new Match();
                    //m.setLocal();
                    //m.setVisitor();
                    m.setDay(resultSet.getInt("day"));

                }
            }
        }
        return matchs;
    }


    public Object findByid(int id) {
        return null;
    }


    public Object findByDay(int day) throws SQLException {
        return null;
    }


    public Object save(Object match) throws SQLException {
        return match;
    }

    public void delete(String dni) throws SQLException {

    }


    public void close() throws Exception {

    }
}
