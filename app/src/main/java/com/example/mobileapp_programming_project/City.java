package com.example.mobileapp_programming_project;

public class City {

    private String name;
    private String attractions;
    private int population;
    private String wikiLink;

    public City(String name, String region, int population, String wikiLink, String img) {
        this.name = name;
        this.attractions = attractions;
        this.population = population;
        this.wikiLink = wikiLink;
    }

    public String getName() {
        return name;
    }

    public String getAttractions() {
        return attractions;
    }

    public int getPopulation() {
        return population;
    }

    public String getWikiLink() {
        return wikiLink;
    }

}
