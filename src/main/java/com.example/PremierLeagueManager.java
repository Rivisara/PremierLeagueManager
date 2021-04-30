package com.example;


import com.example.w1761185.W1761185Application;

import java.io.*;
import java.util.*;


public class PremierLeagueManager implements LeagueManager {

    private final int PremierLFootballClub = 20; // final size of the league
    static final List<FootballClub> footballLeague = new ArrayList<>();
     static final List<match> Matches = new ArrayList<>();
     static final List<FootballClub> sortbyWins = new ArrayList<>();
    static final List<FootballClub> sortbyScore = new ArrayList<>();
     static final List <match> list = new ArrayList<>();

    @Override
    public void AddFootballClub() {
        FootballClub footballClub = new FootballClub();
        Scanner scann = new Scanner(System.in);

        System.out.println("Enter the Name of the Club");
        String clubName = scann.next();

        System.out.println("Enter the location of the club");
        String clubLocation = scann.next();

        System.out.println("* Press 'U' to select university football club.");
        System.out.println("* Press 'S' to select School football club.");
        System.out.println("* Press 'F' to select football club.");
        String answer = scann.next().toUpperCase();

        switch (answer) {
            case "S": {
                System.out.println("Enter the Name of the School");
                String uniName = scann.next();
                break;
            }
            case "U": {
                System.out.println("Enter the Name of the University");
                String uniName = scann.next();
                break;
            }
            case "F":
                break;
            default:
                System.out.println("worng input.try again.");
                break;
        }
        footballClub.setClubName(clubName);
        footballClub.setClubLocation(clubLocation);

        footballLeague.add(footballClub);
    }

    public void addManualMatch(){


    }


    @Override
    public void DeleteFootballClub() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Name of the club you wanted to delete");
        String delete = scan.next();

        for (FootballClub footballClub : footballLeague) {
            if (footballClub.getClubName().equals(delete)) {
                System.out.println("Are you sure you want to delete " + delete + "club..?? ( yes / no )");
                String answer = scan.next();
                if (answer.equals("yes")) {
                    footballLeague.remove(footballClub);
                    System.out.println("Club removed successfully !!");
                    System.out.println(" ");
                    System.out.println("Press any alphabetical key to continue..");
                    String tab = scan.next();
                    break;
                } else if (answer.equals("no")) {
                    break;
                } else {
                    System.out.println("wrong answer!!");
                    break;
                }
            }
        }
    }

    @Override
    public void DisplayStat() {
        Scanner scannr = new Scanner(System.in);
        System.out.println("Enter the name of the club");
        String clubstat = scannr.next();

        for (FootballClub footballClub : footballLeague){
            if (footballClub.getClubName().equals(clubstat)){
                System.out.println(footballClub.getClubName()+" club have won           " +footballClub.getWins()+ " matches");
                System.out.println(footballClub.getClubName()+" club has being defeated "+ footballClub.getDefeats()+ " matches");
                System.out.println(footballClub.getClubName()+" club have drawn         "+ footballClub.getDraws()+ " matches");
                System.out.println(footballClub.getClubName()+" club has played         "+ footballClub.getMatchPlayed()+ " matches");
                System.out.println(footballClub.getClubName()+" club recieved           "+ footballClub.getGoalsReceived()+ " Goals");
                System.out.println(footballClub.getClubName()+" club scored             "+ footballClub.getScore()+ " Goals");
                System.out.println(footballClub.getClubName()+" club has archived       "+ footballClub.getPoints()+ " points");
                break;
            }else{
                System.out.println("No team found under that name !!");
            }
        }
    }

    @Override
    public void AddMatch() {
        System.out.println(Matches);
        match matches = new match();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Date of the match..? eg:(dd/mm/year)");
        String DateM = scan.next();

        if (DateM.contains("/")) {
            String[] DateA = DateM.split("/");
            int days = Integer.parseInt(DateA[0]);
            int months = Integer.parseInt(DateA[1]);
            int years = Integer.parseInt(DateA[2]);

            if (years > 1999 && years < 2021 && months > 0 && months < 13 && days > 0 && days < 32) {
                Date date = new Date(days, months, years);
                matches.setMatchDate(date);
                System.out.println(date);
                }

            if (PremierLeagueManager.footballLeague.size() < 2) {
                System.out.println("there are not enough teams to add match");
                System.out.println(" ");

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
                matches.setTeamAscore(randomteam);
                FootballClub teamB = footballLeague.get(randomteamB);
                matches.setTeamBscore(randomteamB);

                matches.setTeamA(teamA.getClubName());
                matches.setTeamB(teamB.getClubName());

                int randomGoalsA = random.nextInt(5);
                int randomGoalsB = random.nextInt(5);

                matches.setTeamAscore(randomGoalsA);
                matches.setTeamBscore(randomGoalsB);

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
                Matches.add(matches);
            }
        }
    }
    @Override
    public void SaveFile() {
        String filename="FootballClubs.txt";
        try{
            ObjectOutputStream objectSaving =new ObjectOutputStream(new FileOutputStream(filename));
            for(FootballClub footballClub:footballLeague){
                objectSaving.writeObject(footballClub);
            }
            objectSaving.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("data has been saved successfully");
    }

    public void SaveMatch() {
        String file = "Matches.txt";
        try {
            ObjectOutputStream objectSaving = new ObjectOutputStream(new FileOutputStream(file));
            for (match match : Matches) {
                objectSaving.writeObject(match);
            }
            objectSaving.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("data has been saved successfully");
    }

    @Override
    public void Loaddata() throws IOException,ClassNotFoundException {
        File file = new File("FootballClubs.txt");
        try {
            if(file.length()!=0) {
                FileInputStream fileInputSt = new FileInputStream("FootballClubs.txt");
                ObjectInputStream objectInputSt = new ObjectInputStream(fileInputSt);
                for (; ; ) {
                    try {
                        footballLeague.add((FootballClub) objectInputSt.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }
                System.out.println("Previous data has been loaded successfully");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void LeagueTable() {

        for (FootballClub footballClub : footballLeague) {
            System.out.println(footballClub);
        }
    }

    public void LoadMatch() throws IOException,ClassNotFoundException {
        File file = new File("Matches.txt");
        try{
            if(file.length()!=0) {
                FileInputStream fileInputSt = new FileInputStream("Matches.txt");
                ObjectInputStream objectInputSt = new ObjectInputStream(fileInputSt);

                for (; ; ) {
                    try {
                        Matches.add((match) objectInputSt.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }
                System.out.println("Previous data has been loaded successfully");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void Quit() {
        System.exit(0);
    }

    @Override
    public String relegateClubs(){

        for (int i = 0; i <( footballLeague.size()-1); i++) {
            for (int j = i + 1; j < footballLeague.size(); j++) {
                if (footballLeague.get(i).getPoints() > footballLeague.get(j).getPoints()){
                    FootballClub club = footballLeague.get(i);
                    footballLeague.set(i, footballLeague.get(j));
                    footballLeague.set(j, club);
                }
            }
        }
        if (footballLeague.size() > 3){
            for (int i = 0; i <3; i++){
                footballLeague.remove(0);
            }
        } else {
            return "Relegation faild";
        }
        System.out.println(footballLeague);
        return "Relegated!";
    }
}
