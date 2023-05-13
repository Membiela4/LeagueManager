package com.example.leaguemanager2.dao;

import com.example.leaguemanager2.modelDomain.Match;
import com.example.leaguemanager2.modelDomain.Player;
import com.example.leaguemanager2.modelDomain.Team;
import com.example.leaguemanager2.utils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatchDAO implements DAO<Match>  {
    private final static String FINDALL = "select * from `match`";
    private final static String FINDBYID = "select * from `match` where match_id = ?";

    private final static String FINDBYDAY = "select * from `match` where day = ?";
    private final static String FINDBYTEAM = "select * from `match` where local_id = ? or visitor_id =?";
    private final static String DELETE = "delete from `match` where match_id = ?";
    private final static String UPDATE = "update `match` set match_id = ?,local_id =?, visitor_id = ?, day = ?  where match_id = ?";
    private final static String INSERT = "insert into `match`(match_id,local_id,visitor_id,day) values (?,?,?,?)";

    private Connection connection;
    public MatchDAO() {this.connection = Connect.getConnect();}

    public MatchDAO(Connection connection) {this.connection = connection;}
    private PlayerDAO playerDAO = new PlayerDAO();
    private TeamDAO teamDAO = new TeamDAO();

    public List<Match> findAll() throws SQLException {
        List<Match> matchs = new ArrayList<>();

        try(PreparedStatement pst = this.connection.prepareStatement(FINDALL)){

            try(ResultSet resultSet = pst.executeQuery()) {

                while(resultSet.next()) {
                    Match m = new Match();
                    m.setMatch_id(resultSet.getInt("match_id"));
                    m.setLocal(teamDAO.findByid(resultSet.getInt("local_id")));
                    m.setVisitor(teamDAO.findByid(resultSet.getInt("visitor_id")));
                    m.setDay(resultSet.getInt("day"));

                    matchs.add(m);

                }
            }
        }
        return matchs;
    }


    public Match findByid(int id) {

        try(PreparedStatement pst = this.connection.prepareStatement(FINDBYID)){
            pst.setInt(1,id);
            try(ResultSet resultSet = pst.executeQuery()) {
                Match m = new Match();
                m.setMatch_id(resultSet.getInt("match_id"));
                m.setLocal(teamDAO.findByid(resultSet.getInt("local_id")));
                m.setVisitor(teamDAO.findByid(resultSet.getInt("visitor_id")));
                m.setDay(resultSet.getInt("day"));

                return m;


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public List<Match> findByTeam(int id) throws SQLException {
        List<Match> matchs = new ArrayList<>();
        Match result = null;
        PreparedStatement pst =this.connection.prepareStatement(FINDBYTEAM);
        pst.setInt(1,id);
        pst.setInt(2,id);
        try(ResultSet rs = pst.executeQuery()) {
            if(rs.next()) {
                result  = new Match();
                result.setMatch_id(rs.getInt("match_id"));
                result.setLocal(teamDAO.findByid(rs.getInt("local_id")));
                result.setVisitor(teamDAO.findByid(rs.getInt("visitor_id")));
                result.setDay(rs.getInt("day"));

                matchs.add(result);

            }
            return matchs;
        }

    }

    @Override
    public Match save(Match entity) throws SQLException {
        Match result = new Match();
        if(entity==null) {
            Match m = findByid(entity.getMatch_id());
            if(m != null) {
                //INSERT
                try (PreparedStatement pst = this.connection.prepareStatement(INSERT)) {
                    pst.setInt(1, entity.getMatch_id());
                    pst.setInt(2, entity.getLocal().getTeam_id());
                    pst.setInt(3, entity.getVisitor().getTeam_id());
                    pst.setInt(4,entity.getDay());
                    pst.executeUpdate();
                }
            }else {
                //UPDATE
                try (PreparedStatement pst = this.connection.prepareStatement(UPDATE)) {
                    pst.setInt(1, entity.getMatch_id());
                    pst.setInt(2, entity.getLocal().getTeam_id());
                    pst.setInt(3, entity.getVisitor().getTeam_id());
                    pst.setInt(4,entity.getDay());
                    pst.setInt(5,entity.getMatch_id());
                    pst.executeUpdate();
                }
            }
            result=entity;
        }
        return result;
    }

    @Override
    public void delete(Match m) throws SQLException {
        if(m!=null) {
            try(PreparedStatement pst=this.connection.prepareStatement(DELETE)){
                pst.setInt(1, m.getMatch_id());
                pst.executeUpdate();
                pst.close();
            }

        }
    }


    public Object findByDay(int day) throws SQLException {

        try(PreparedStatement pst = this.connection.prepareStatement(FINDBYDAY)){
            pst.setInt(1,day);
            try(ResultSet resultSet = pst.executeQuery()) {
                    Match m = new Match();
                    m.setMatch_id(resultSet.getInt("match_id"));
                    m.setLocal(teamDAO.findByid(resultSet.getInt("local_id")));
                    m.setVisitor(teamDAO.findByid(resultSet.getInt("visitor_id")));
                    m.setDay(resultSet.getInt("day"));

                    return m;


            }
        }

    }

    public void close() throws Exception {

    }
}
