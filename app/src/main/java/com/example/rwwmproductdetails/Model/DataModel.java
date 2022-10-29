package com.example.rwwmproductdetails.Model;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
//
    @SerializedName("image")
    public image image;
//    @SerializedName("slug")
//    private String slug;
    @SerializedName("short_description")
    private String short_description;
//    @SerializedName("status")
//    private String status;

    public DataModel(String id, String name, String short_description, image image ) {
        this.id = id;
        this.name = name;
//        this.slug = slug;
        this.image=image;
        this.short_description = short_description;
//        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
//
//    public String getSlug() {
//        return slug;
//    }

    public String getShort_description() {
        return short_description;
    }

//    public String getStatus() {
//        return status;
//    }
}
