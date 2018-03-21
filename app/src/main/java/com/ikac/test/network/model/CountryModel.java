package com.ikac.test.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ikac on 3/21/18.
 */

public class CountryModel extends BaseModel {

    @SerializedName("ID")
    private int id;
    @SerializedName("Name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
