package com.example.mobileapp_programming_project;

public class City {

    private String name;
    private String region;
    private String population;
    private String wikiLink;
    private String img;

    public City(String name, String region, String population, String wikiLink, String img) {
        this.name = name;
        this.region = region;
        this.population = population;
        this.wikiLink = wikiLink;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getPopulation() {
        return population;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public String getImg() {
        return img;
    }
}
