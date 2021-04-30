package com.example;

import java.util.Objects;

public class UniversityFootballClub extends FootballClub {
    private String UniversityName;

    public UniversityFootballClub(String ClubName,String ClubLocation,String UniversityName) {
        super();
        this.UniversityName=UniversityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(UniversityName, that.UniversityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), UniversityName);
    }

    @Override
    public String toString() {
        return "UniversityFootballClub{" +
                "UniversityName='" + UniversityName + '\'' +
                '}';
    }
}
