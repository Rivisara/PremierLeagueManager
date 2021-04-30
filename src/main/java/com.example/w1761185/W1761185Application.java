package com.example.w1761185;


import com.example.PremierLeagueManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class W1761185Application {
    public static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    public static void main(String[] args)throws IOException, ClassNotFoundException {
        premierLeagueManager.LoadMatch();
        premierLeagueManager.Loaddata();
        SpringApplication.run(W1761185Application.class, args);
        menu();
    }

    public static void menu() throws IOException, ClassNotFoundException{
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("-Premier League Championship Manager-");
            System.out.println(" ");
            System.out.println(" = = = = = = = = Menu = = = = = = = =");
            System.out.println(" ");
            System.out.println("# Press 'A' to Create and add a new football club to the Premier league");
            System.out.println("# Press 'B' to Delete an existing football club from the Premier league");
            System.out.println("# Press 'C' to Display the various statistics for a selected football club");
            System.out.println("# Press 'D' to Display the Premier league table");
            System.out.println("# Press 'E' to Relegate");
            System.out.println("# Press 'F' to Add a match");
            System.out.println("# Press 'G' to Save all the information to a file");
            System.out.println("# Press 'H' to Load previous information from the file");
            System.out.println("# Press 'I' to Open the GUI");
            System.out.println("# Press 'Q' to Quit the program");
            String Answer = scanner.next().toLowerCase();
            switch (Answer) {
                case "a":
                    premierLeagueManager.AddFootballClub();
                    break;
                case "b":
                    premierLeagueManager.DeleteFootballClub();
                    break;
                case "c":
                    premierLeagueManager.DisplayStat();
                    break;
                case "d":
                    premierLeagueManager.LeagueTable();
                    break;
                case "e":
                    premierLeagueManager.relegateClubs();
                    break;
                case "f":
                    premierLeagueManager.AddMatch();
                    break;
                case "g":
                    premierLeagueManager.SaveFile();
                    premierLeagueManager.SaveMatch();
                    break;
                case "h":
                    premierLeagueManager.Loaddata();
                    break;
                case "i":
                    Runtime rt = Runtime.getRuntime();
                    String url = "http://localhost:4200/homepage";
                    rt.exec("open " + url);
                    break;
                case "q":
                    premierLeagueManager.Quit();
                default:
                    System.out.println("Try Again !!");
            }
        }
    }
}