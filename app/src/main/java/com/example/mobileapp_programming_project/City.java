package com.example.mobileapp_programming_project;

import com.google.gson.annotations.SerializedName;

public class City {

    private String name;
    @SerializedName("auxdata")
    private String imgURL;
    @SerializedName("company")
    private String population;
    @SerializedName("location")
    private String wikiURL;

    @SerializedName("category")
    private String country;

    public City(String name, String region, String population, String wikiURL, String imgURL) {
        this.name = name;
        this.population = population;
        this.imgURL = getImgURL();
        this.wikiURL = wikiURL;
    }

    public String getName() {
        return name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getPopulation() {
        return population;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public String getCountry() {
        return country;
    }

}
