package modelDomain;

import java.util.List;
import java.util.Objects;

public class Team {
      private String team_id;
      private String name;
      private List<Player> players;

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team(String name) {
        this.name = name;
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


}
