package com.s4680244.Models;


import java.io.Serializable;

public class Entity implements Serializable {
    private String species;
    private String scientificName;
    private String habitat;
    private String diet;
    private String conservationStatus;
    private int averageLifespan;
    private String description;

    // Getters
    public String getSpecies() { return species; }
    public String getScientificName() { return scientificName; }
    public String getHabitat() { return habitat; }
    public String getDiet() { return diet; }
    public String getConservationStatus() { return conservationStatus; }
    public int getAverageLifespan() { return averageLifespan; }
    public String getDescription() { return description; }
}
