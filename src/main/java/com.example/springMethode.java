package com.example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import static com.example.LeagueManager.PremierLFootballClub;
import static com.example.PremierLeagueManager.*;

@Component
public class springMethode {
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    private final Sorting sorting = new Sorting();

    public String addClubs(FootballClub club){
        for(FootballClub footballClub : footballLeague){
            if(footballClub.equals(club)){
                return "This club is alredy exists!";
            }
        }
        if(footballLeague.size()==PremierLFootballClub){
            return "league is Full!!";
        }
        if(!club.getClubName().isEmpty()){
            footballLeague.add(club);
        }else{
            return "Fields Are Empty";
        }
        return "Successfull Added!!";
    }


    public List<FootballClub> PLeagueTable() {
        footballLeague.sort(sorting.sortByPoints);
        return footballLeague ;
    }


    public List<FootballClub> PLeagueTableS(){
        sortbyScore.clear();
        sortbyScore.addAll(footballLeague);
        sortbyScore.sort(sorting.sortByScore);
        return sortbyScore;
    }


    public List<FootballClub> PLeagueTableW(){
        sortbyWins.clear();
        sortbyWins.addAll(footballLeague);
        sortbyWins.sort(sorting.sortByWins);
        return sortbyWins;
    }


    public List<match> matchTable() {
        Matches.sort(sorting.matchDatesort);
        return Matches ;
    }

    public String saveDatas(){
        premierLeagueManager.SaveFile();
        premierLeagueManager.SaveMatch();
        return "Saved Successfully!!";
    }


    public String findmatchdate(Date date){
        list.clear();
        int days = date.getDay();
        int months = date.getMonth();
        int years = date.getYear();

        for (match matches : Matches) {
            if (matches.getMatchDate().getDay()==days && matches.getMatchDate().getMonth()==months && matches.getMatchDate().getYear()==years ){
                list.add(matches);
            }
        }
        Matches.sort(sorting.matchDatesort);
        if(list.isEmpty()){
            return "There are no matches played under that date";
        }
        return "results founded!";
    }


    public List<match> findMatch(){
        list.sort(sorting.matchDatesort);
        return list;
    }


    public String addmatchDate(Date date){
        if(date.getDay()==0){
            return "invalid date!";
        }
        match matchess = new match();
        matchess.setMatchDate(date);
        if (footballLeague.size() < 2) {
            return "There are no enough Clubs !!";
        } else {
            Random random = new Random();
            int randomteam;
            int randomteamB;
            do {
                randomteam = random.nextInt(footballLeague.size());
                randomteamB = random.nextInt(footballLeague.size());
            }
            while (randomteam == randomteamB);

            FootballClub teamA = footballLeague.get(randomteam);
            matchess.setTeamAscore(randomteam);
            FootballClub teamB = footballLeague.get(randomteamB);
            matchess.setTeamBscore(randomteamB);

            matchess.setTeamA(teamA.getClubName());
            matchess.setTeamB(teamB.getClubName());

            int randomGoalsA = random.nextInt(5);
            int randomGoalsB = random.nextInt(5);

            matchess.setTeamAscore(randomGoalsA);
            matchess.setTeamBscore(randomGoalsB);

            teamA.setScore(teamA.getScore() + randomGoalsA);
            teamB.setScore(teamB.getScore() + randomGoalsB);
            teamA.setGoalsReceived(teamA.getGoalsReceived() + randomGoalsB);
            teamB.setGoalsReceived(teamB.getGoalsReceived() + randomGoalsA);
            teamA.setMatchPlayed(teamA.getMatchPlayed() + 1);
            teamB.setMatchPlayed(teamB.getMatchPlayed() + 1);

            if (randomGoalsA > randomGoalsB) {
                System.out.println("win");
                teamA.setWins(teamA.getWins() + 1);
                teamB.setDefeats(teamB.getDefeats() + 1);
                teamA.setPoints(teamA.getPoints() + 3);
                teamB.setPoints(teamB.getPoints() + 1);
            } else if (randomGoalsA < randomGoalsB) {
                System.out.println("lost");
                teamB.setPoints(teamB.getPoints() + 3);
                teamA.setPoints(teamA.getPoints() + 1);
                teamB.setWins(teamB.getWins() + 1);
                teamA.setDefeats(teamA.getDefeats() + 1);
            } else {
                System.out.println("draw");
                teamA.setDraws(teamA.getDraws() + 1);
                teamB.setDraws(teamB.getDraws() + 1);
            }
            Matches.add(matchess);
            System.out.println(teamA.getClubName() + " VS " + teamB.getClubName());
        }
        Matches.sort(sorting.matchDatesort);
        return "Match Added Successfully";
    }


    public String deleteClubs(String clubName){
        footballLeague.removeIf(footballClub -> clubName.equals(footballClub.getClubName()));
        return "Removed Successfully!";
    }
}
