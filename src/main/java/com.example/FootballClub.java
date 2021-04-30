package com.example;

import com.example.SportsClub;

import java.util.Objects;

public class FootballClub extends SportsClub {
    private int Wins;
    private int Draws;
    private int Defeats;
    private int MatchPlayed;
    private int GoalsReceived;
    private int Score;
    private int Points;

    public FootballClub() {
        super();
    }

    public FootballClub(String ClubName, String ClubLocation, int wins, int draws, int defeats, int matchPlayed, int goalsReceived, int score, int points) {
        super(ClubName, ClubLocation);
        Wins = wins;
        Draws = draws;
        Defeats = defeats;
        MatchPlayed = matchPlayed;
        GoalsReceived = goalsReceived;
        Score = score;
        Points = points;
    }

    public int getWins() {
        return Wins;
    }

    public void setWins(int Wins) {
        this.Wins=Wins;
    }

    public int getDraws() {
        return Draws;
    }

    public void setDraws(int Draws) {
        this.Draws = Draws;
    }

    public int getDefeats() {
        return Defeats;
    }

    public void setDefeats(int Defeats) {
        this.Defeats = Defeats;
    }

    public int getMatchPlayed() {
        return MatchPlayed;
    }

    public void setMatchPlayed(int MatchPlayed) {
        this.MatchPlayed = MatchPlayed;
    }

    public int getGoalsReceived() {
        return GoalsReceived;
    }

    public void setGoalsReceived(int GoalsReceived) {
        this.GoalsReceived = GoalsReceived;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        FootballClub that = (FootballClub) other;
        return Wins == that.Wins &&
                Draws == that.Draws &&
                Defeats == that.Defeats &&
                MatchPlayed == that.MatchPlayed &&
                GoalsReceived == that.GoalsReceived &&
                Score == that.Score &&
                Points == that.Points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Wins, Draws, Defeats, MatchPlayed, GoalsReceived, Score, Points);
    }

    @Override
    public String toString() {
        return super.toString()+" | Wins = " + Wins +
                " | Points = " + Points+
                " | Defeats = " + Defeats +
                " | MatchPlayed = " + MatchPlayed +
                " | GoalsReceived = " + GoalsReceived +
                " | GoalsScored = " + Score +
                " | Draws = " + Draws;
    }
}
