package com.example.leaguemanager2.modelDomain;

import java.net.URL;
import java.sql.Blob;
import java.util.List;
import java.util.Objects;

public class Team {
      private int team_id;
      private String name;
      private String abbreviation;
      private List<Player> players;
      private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }

    public Team(int id, String name, String abbreviation) {
        this.team_id = id;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(getTeam_id(), team.getTeam_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeam_id());
    }


    @Override
    public String toString() {
        return  name + " " + abbreviation;
    }
}
