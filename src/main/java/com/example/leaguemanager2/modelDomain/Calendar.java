package com.example.leaguemanager2.modelDomain;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private List<Match> matchs;
    private List<Team> teams;
    public Calendar() {
        this.matchs = new ArrayList<>();
        this.teams = teams;
    }


    public List<Match> createCalendar(List<Team> teams) {
            int n = teams.size();
            int half = n / 2;
            int day = 1;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    Team local = teams.get(i);
                    Team visitor = teams.get(j);
                     day++;
                     Match match = new Match(local, visitor, day);
                    matchs.add(match);
                }
            }
            return matchs;
        }
    }
