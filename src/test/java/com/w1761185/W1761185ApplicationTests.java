package com.w1761185;

import com.example.*;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
class W1761185ApplicationTests {
    springMethode spring = new springMethode();
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    springMethode springmethode = new springMethode();
    FootballClub club = new FootballClub();


    @Test
    void addClubTest() {
        club.setClubName("testClub");
        club.setClubLocation("testLocation");
        Assert.assertEquals("Successfull Added!!",spring.addClubs(club));
    }

    @Test
    void addClubTest1(){
        club.setClubName("");
        club.setClubLocation("");
        Assert.assertEquals("Fields Are Empty",spring.addClubs(club));
    }

    @Test
    void leagTableTest(){
        List<FootballClub> tempCheck = new ArrayList<>();
        tempCheck.add(new FootballClub("ColomboKings", "colombo", 0, 0, 0, 0, 0, 0, 0));
        springmethode.addClubs(new FootballClub("ColomboKings", "colombo",0, 0, 0, 0, 0, 0, 0));
        Assert.assertEquals(tempCheck,springmethode.PLeagueTable());
    }

    @Test
    void GuiFileSaving(){
        Assert.assertEquals("Saved Successfully!!",springmethode.saveDatas());
    }

    @Test
    void Delete(){
        FootballClub tempCheck = new FootballClub("ColomboKings", "colombo", 0, 0, 0, 0, 0, 0, 0);
        springmethode.addClubs(new FootballClub("ColomboKings", "colombo",0, 0, 0, 0, 0, 0, 0));
        Assert.assertEquals("Removed Successfully!",springmethode.deleteClubs(tempCheck.getClubName()));
    }
}
