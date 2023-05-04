package modelDomain;

import java.util.Objects;

public class Match {
    private  String match_id;
    private Team local;
    private Team visitor;
    private int day;

    //Getter and Setters
    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public Team getLocal() {
        return local;
    }

    public void setLocal(Team local) {
        this.local = local;
    }

    public Team getVisitor() {
        return visitor;
    }

    public void setVisitor(Team visitor) {
        this.visitor = visitor;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    //Constructors
    public Match(Team local, Team visitor, int day) {
        this.local = local;
        this.visitor = visitor;
        this.day = day;
    }
    //Equals and HashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(getMatch_id(), match.getMatch_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatch_id());
    }

    //ToString

    @Override
    public String toString() {
        return "Match{" +
                "match_id='" + match_id + '\'' +
                ", local=" + local.getName() +
                ", visitor=" + visitor.getName() +
                ", day=" + day +
                '}';
    }

}
