package com.example;

import java.util.Objects;

public class SchoolFootballClub extends FootballClub{
    private String SchoolName;

    public SchoolFootballClub(String ClubName,String ClubLocation,String SchoolName) {
        super();
        this.SchoolName = SchoolName;
    }

    public SchoolFootballClub() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return Objects.equals(SchoolName, that.SchoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SchoolName);
    }


}
