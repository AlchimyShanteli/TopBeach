package com.topbeach.beachmodel;

/**
 * Created by Alchimy on 4/25/2017.
 */

public class BeachModel {
    private int _id;
    private String nameCountry;
    private String nameIsland;
    private String nameCity;
    private String nameBeach;
    private String descriptionBeach;
    private String idUrl;

    public BeachModel(int id, String nameCountry,String nameIsland, String nameCity, String nameBeach, String descriptionBeach, String idUrl) {
        this._id = id;
        this.nameCountry = nameCountry;
        this.nameIsland = nameIsland;
        this.nameCity = nameCity;
        this.nameBeach = nameBeach;
        this.descriptionBeach = descriptionBeach;
        this.idUrl = idUrl;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public void setNameIsland(String nameIsland) {
        this.nameIsland = nameIsland;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public void setNameBeach(String nameBeach) {
        this.nameBeach = nameBeach;
    }

    public void setDescriptionBeach(String descriptionBeach) {
        this.descriptionBeach = descriptionBeach;
    }

    public void setIdUrl(String idUrl) {
        this.idUrl = idUrl;
    }

    public String getNameIsland() {
        return nameIsland;
    }

    public String getDescriptionBeach() {
        return descriptionBeach;
    }

    public String getImageUrl() {
        return idUrl;
    }

    public int get_id() {
        return _id;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public String getNameCity() {
        return nameCity;
    }

    public String getNameBeach() {
        return nameBeach;
    }


}
