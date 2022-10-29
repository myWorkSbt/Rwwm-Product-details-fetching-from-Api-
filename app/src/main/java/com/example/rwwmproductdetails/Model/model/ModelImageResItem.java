package com.example.rwwmproductdetails.Model.model;

import com.google.gson.annotations.SerializedName;

public class ModelImageResItem{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName(" image")
	private Image image;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Image getImage(){
		return image;
	}
}