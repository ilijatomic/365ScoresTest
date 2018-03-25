package com.ikac.test.network.model;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.HashCodeBuilder;


/**
 * Created by ikac on 3/21/18.
 */

public class CompetitionModel extends BaseModel {

    @SerializedName("ID")
    private int id;
    @SerializedName("CID")
    private int cid;
    @SerializedName("Name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(cid).append(name).toHashCode();
    }

    @Override
    public String toString() {
        return "CompetitionModel{" +
                "id=" + id +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }

}
