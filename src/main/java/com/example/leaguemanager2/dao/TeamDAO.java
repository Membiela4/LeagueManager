package com.example.leaguemanager2.dao;

import com.example.leaguemanager2.modelDomain.Team;
import com.example.leaguemanager2.utils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    private final static String FINDALL = "select * from team";
    private final static String FINDBYNAME = "select * from team where name = ?";
    private final static String DELETE = "delete from team where team_id = ?";
    private final static String UPDATE = "update team set name = ?, abbreviation where team_id = ?";
    private final static String INSERT = "insert into team(team_id,name,abbreviation,icon,num_players) values(?,?,?,?,?)";

    private Connection connection;

    public static PlayerDAO playerdao = new PlayerDAO();

    public TeamDAO(Connection connection) {this.connection = connection;}
    public TeamDAO() {this.connection = Connect.getConnect();}

    public List findAll() throws SQLException {
        List<Team> teams = new ArrayList<>();

        try(PreparedStatement pst = this.connection.prepareStatement(FINDALL)){

            try(ResultSet resultSet = pst.executeQuery()) {

                while(resultSet.next()) {
                    Team t = new Team();
                    t.setTeam_id(resultSet.getInt("team_id"));
                    t.setName(resultSet.getString("name"));
                    t.setAbbreviation(resultSet.getString("last_name"));
                    t.getIcon();
                    t.setPlayers(playerdao.findByTeamWhole(t.getTeam_id()));
                    teams.add(t);
                }
            }
        }
        return teams;
    }


    public Team FindByid(int id) {
        return null;
    }


    public Team FindByName(String name) throws SQLException {
        Team result = null;
        PreparedStatement pst =this.connection.prepareStatement(FINDBYNAME);
        pst.setString(1,name);
        try(ResultSet rs = pst.executeQuery()) {
            if(rs.next()) {
                result = new Team();
                result.setName(rs.getString("name"));
                result.setTeam_id(rs.getInt("team_id"));
                result.setAbbreviation(rs.getString("abbreviation"));
                result.setIcon(rs.getBlob("icon"));
                result.setPlayers(playerdao.findByTeamWhole(result.getTeam_id()));

            }
            return result;
        }
    }


    public Object save(Team entity) throws SQLException {
        Team result = new Team();
        if (entity != null) {
            Team t = FindByid(entity.getTeam_id());
            if (t == null) {
                //INSERT
                try (PreparedStatement pst = this.connection.prepareStatement(INSERT)) {
                    pst.setInt(1, entity.getTeam_id());
                    pst.setString(2, entity.getName());
                    pst.setString(3, entity.getAbbreviation());
                    pst.setBlob(4,entity.getIcon());
                    pst.executeUpdate();

                }
            }

            result = entity;
        }
        return result;
    }

    //@Override
    public void delete(String id) throws SQLException {
        if(id!=null) {
            try(PreparedStatement pst=this.connection.prepareStatement(DELETE)){
                pst.setString(1, id);
                pst.executeUpdate();
                pst.close();
            }

        }
    }

    //@Override
    public void close() throws Exception {
        playerdao.close();
        connection.close();
    }
}
