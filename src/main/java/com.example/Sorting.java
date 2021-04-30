package com.example;

import java.util.Comparator;

public class Sorting {

    public Comparator<FootballClub> sortByPoints = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub other1, FootballClub other2) {
            if (other1.getPoints() < other2.getPoints()) {
                return 1;
            } else if (other1.getPoints() > other2.getPoints()) {
                return -1;
            } else if (other1.getPoints() == other2.getPoints()) {
                int GoalDiff1 = other1.getScore() - other1.getGoalsReceived();
                int GoalDiff2 = other2.getScore() - other2.getGoalsReceived();
                if (GoalDiff1 < GoalDiff2) {
                    return 1;
                } else if (GoalDiff1 > GoalDiff2) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    };

    public Comparator<FootballClub> sortByScore = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub other1, FootballClub other2) {
            if (other1.getScore() < other2.getScore()) {
                return 1;
            } else if (other1.getScore() > other2.getScore()) {
                return -1;
            } else if (other1.getScore() == other2.getScore()) {
                int GoalDiff1 = other1.getScore()-other1.getGoalsReceived();
                int GoalDiff2 = other2.getScore()-other2.getGoalsReceived();
                if (GoalDiff1<GoalDiff2) {
                    return 1;
                } else if (GoalDiff1>GoalDiff2) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    };

    public Comparator<FootballClub> sortByWins = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub other1, FootballClub other2) {
            if (other1.getWins() < other2.getWins()) {
                return 1;
            } else if (other1.getWins() > other2.getWins()) {
                return -1;
            } else if (other1.getWins() == other2.getWins()) {
                int GoalDiff1 = other1.getScore()-other1.getGoalsReceived();
                int GoalDiff2 = other2.getScore()-other2.getGoalsReceived();
                if (GoalDiff1<GoalDiff2) {
                    return 1;
                } else if (GoalDiff1>GoalDiff2) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    };

    public Comparator<match> matchDatesort = new Comparator<match>() {
        @Override
        public int compare(match other1, match other2) {
            if (other1.getMatchDate().getYear() > other2.getMatchDate().getYear()) {
                return 1;
            } else if (other1.getMatchDate().getYear() < other2.getMatchDate().getYear()) {
                return -1;
            } else if (other1.getMatchDate().getYear() == other2.getMatchDate().getYear()) {
                if (other1.getMatchDate().getMonth() > other2.getMatchDate().getMonth()) {
                    return 1;
                } else if (other1.getMatchDate().getMonth() < other2.getMatchDate().getMonth()) {
                    return -1;
                } else if(other1.getMatchDate().getMonth() == other2.getMatchDate().getMonth()){
                    if(other1.getMatchDate().getDay() > other2.getMatchDate().getDay()){
                        return 1;
                    }else if (other1.getMatchDate().getDay() < other2.getMatchDate().getDay()){
                        return -1;
                    }else{
                        return 0;
                    }
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        }
    };
}