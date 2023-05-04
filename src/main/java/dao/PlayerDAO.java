package dao;

import modelDomain.Player;
import utils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO implements DAO {
    private final static String FINDALL = "select * from player";
    private final static String FINDBYNAME = "select * from player where name = ?";
    private final static String INSERT = "insert into player(player_id,name,last_name,alias,dorsal) values(?,?,?,?,?)";
     private Connection connection;
     public PlayerDAO(Connection connection) {this.connection = connection;}
    public PlayerDAO() {this.connection = Connect.getConnect();}

    @Override
    public List findAll() throws SQLException {
        List<Player> players = new ArrayList<>();

        try(PreparedStatement pst = this.connection.prepareStatement(FINDALL)){

            try(ResultSet resultSet = pst.executeQuery()) {

                while(resultSet.next()) {
                    Player p = new Player();
                    p.setPlayer_id(resultSet.getInt("player_id"));
                    p.setName(resultSet.getString("name"));
                    p.setLastName(resultSet.getString("last_name"));
                    p.setAlias(resultSet.getString("alias"));
                    p.setDorsal(resultSet.getInt("dorsal"));
                    players.add(p);
                }
            }
        }
        return players;
    }

    @Override
    public Player FindByid(int player_id) {
        return null;
    }

    @Override
    public Player FindByName(String name) throws SQLException {
        Player result = null;
        PreparedStatement pst =this.connection.prepareStatement(FINDBYNAME);
        pst.setString(1,name);
            try(ResultSet rs = pst.executeQuery()) {
                if(rs.next()) {
                    result = new Player();
                    result.setName(rs.getString("name"));
                    result.setPlayer_id(rs.getInt("player_id"));
                    result.setLastName(rs.getString("last_name"));
                    result.setAlias(rs.getString("alias"));
                    result.setDorsal(rs.getInt("dorsal"));

                }
                return result;
            }
    }

    @Override
    public Object save(Object entity) throws SQLException {
        return null;
    }


    public Object save(Player entity) throws SQLException {
        Player result = new Player();
        if (entity != null) {
            Player p = FindByid(entity.getPlayer_id());
            if (p == null) {
                //INSERT
                try (PreparedStatement pst = this.connection.prepareStatement(INSERT)) {
                    pst.setInt(1, entity.getPlayer_id());
                    pst.setString(2, entity.getName());
                    pst.setString(3, entity.getLastName());
                    pst.executeUpdate();

                }
            }

            result = entity;
        }
        return result;
    }

    @Override
    public void delete(String dni) {

    }

    @Override
    public void close() throws Exception {

    }
}
