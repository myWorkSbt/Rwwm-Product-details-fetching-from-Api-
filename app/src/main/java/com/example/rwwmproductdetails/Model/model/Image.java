package com.example.rwwmproductdetails.Model.model;

import com.google.gson.annotations.SerializedName;

public class Image{

	@SerializedName("date_modified_gmt")
	private String dateModifiedGmt;

	@SerializedName("date_modified")
	private String dateModified;

	@SerializedName("src")
	private String src;

	@SerializedName("date_created")
	private String dateCreated;

	@SerializedName("name")
	private String name;

	@SerializedName("alt")
	private String alt;

	@SerializedName("date_created_gmt")
	private String dateCreatedGmt;

	@SerializedName("id")
	private int id;

	public String getDateModifiedGmt(){
		return dateModifiedGmt;
	}

	public String getDateModified(){
		return dateModified;
	}

	public String getSrc(){
		return src;
	}

	public String getDateCreated(){
		return dateCreated;
	}

	public String getName(){
		return name;
	}

	public String getAlt(){
		return alt;
	}

	public String getDateCreatedGmt(){
		return dateCreatedGmt;
	}

	public int getId(){
		return id;
	}
}