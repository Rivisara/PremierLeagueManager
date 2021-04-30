package com.example;

import java.io.IOException;
import java.util.List;

public interface LeagueManager {
    int PremierLFootballClub = 20;
    void AddFootballClub();
    void DeleteFootballClub();
    void DisplayStat();
    void AddMatch() throws Exception;
    void SaveFile();
    void Loaddata() throws IOException, ClassNotFoundException;

    void LeagueTable();

    void Quit();

    String relegateClubs();
}
