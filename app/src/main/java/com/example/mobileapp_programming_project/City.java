package com.example.mobileapp_programming_project;

import com.google.gson.annotations.SerializedName;

public class City {

    private String name;
    @SerializedName("auxdata")
    private String imgLink;
    @SerializedName("company")
    private String population;
    @SerializedName("location")
    private String wikiLink;

    public City(String name, String region, String population, String wikiLink, String imgLink) {
        this.name = name;
        this.population = population;
        this.imgLink = imgLink;
        this.wikiLink = wikiLink;
    }

    public String getName() {
        return name;
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getPopulation() {
        return population;
    }

    public String getWikiLink() {
        return wikiLink;
    }

}
