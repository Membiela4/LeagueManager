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

public class MatchDAO implements DAO<Match>  {
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


    public Match findByid(int id) {
        return null;
    }

    @Override
    public Match findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public Match save(Match entity) throws SQLException {
        return null;
    }

    @Override
    public void delete(Match o) throws SQLException {

    }


    public Object findByDay(int day) throws SQLException {
        return null;
    }

    public void close() throws Exception {

    }
}
