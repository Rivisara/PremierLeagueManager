package com.example.w1761185;
import com.example.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class premierLeagueAPI {
    springMethode spring = new springMethode();

    @GetMapping("/table")
    public List<FootballClub> getRequest(){
        return spring.PLeagueTable();
    }

    @GetMapping("/tablescore")
    public List<FootballClub> getRequestS(){
        return spring.PLeagueTableS();
    }

    @GetMapping("/tablewin")
    public List<FootballClub> getRequestW(){
        return spring.PLeagueTableW();
    }

    @GetMapping("/match")
    public List<match> getRequestm(){
        return spring.matchTable();
    }

    @PostMapping("/clubs")
    public String addClubss(@RequestBody FootballClub club){
        return spring.addClubs(club);
    }

    @PostMapping("/addmatch")
    public String addmatches(@RequestBody Date date){
        return spring.addmatchDate(date);
    }

    @PostMapping("/find")
    public String find(@RequestBody Date date){
        return spring.findmatchdate(date);
    }

    @PostMapping("/save")
    public String savedata(){
        return spring.saveDatas();
    }

    @PostMapping("/delete")
    public String delete(@RequestBody String clubName){
        return spring.deleteClubs(clubName);
    }

    @GetMapping("/findmatch")
    public List<match> findMatch(){
        return spring.findMatch();
    }
}
