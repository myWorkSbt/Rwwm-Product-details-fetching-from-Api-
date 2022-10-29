package com.example.rwwmproductdetails.Model.CategoryDetailsModel;

import com.google.gson.annotations.SerializedName;

public class CategoryDetailsResponseModelItem{

	@SerializedName("image")
	private Image image;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public Image getImage(){
		return image;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}