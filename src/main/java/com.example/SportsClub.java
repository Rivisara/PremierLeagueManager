package com.example;

import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {
    private String ClubName;
    private String ClubLocation;

    public SportsClub(String ClubName, String ClubLocation) {
        this.ClubName = ClubName;
        this.ClubLocation = ClubLocation;
    }

    public SportsClub() {

    }

    public String getClubName() {
        return ClubName;
    }

    public void setClubName(String clubName) {
        ClubName = clubName;
    }

    public String getClubLocation() {
        return ClubLocation;
    }

    public void setClubLocation(String clubLocation) {
        ClubLocation = clubLocation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(ClubName, that.ClubName) &&
                Objects.equals(ClubLocation, that.ClubLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ClubName, ClubLocation);
    }

    @Override
    public String toString() {
        return "ClubName = " + ClubName +
                " | Club Location = " + ClubLocation;
    }
}




