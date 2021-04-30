package com.example;

import java.io.Serializable;

public class match implements Serializable {
    private Date MatchDate;
    private String teamA;
    private String teamB;
    private int teamAscore;
    private int teamBscore;

    public match(){
    }

    public match(Date MatchDate,String teamA,String teamB,int teamAscore,int teamBscore){
        this.MatchDate=MatchDate;
        this.teamA=teamA;
        this.teamB=teamB;
        this.teamAscore=teamAscore;
        this.teamBscore=teamBscore;

    }

    public Date getMatchDate() {
        return MatchDate;
    }
    public void setMatchDate(Date matchDate){
        MatchDate=matchDate;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getTeamAscore() {
        return teamAscore;
    }

    public void setTeamAscore(int teamAscore) {
        this.teamAscore = teamAscore;
    }

    public int getTeamBscore() {
        return teamBscore;
    }

    public void setTeamBscore(int teamBscore) {
        this.teamBscore = teamBscore;
    }



    @Override
    public String toString() {
        return " MatchDate = " + MatchDate +
                "| teamA = " + teamA +
                "| teamB = " + teamB +
                "| teamAscore = " + teamAscore +
                "| teamBscore = " + teamBscore;
    }
}

