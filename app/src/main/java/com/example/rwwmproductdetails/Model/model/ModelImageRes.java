package com.example.rwwmproductdetails.Model.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ModelImageRes{

	@SerializedName("ModelImageRes")
	private List<ModelImageResItem> modelImageRes;

	public List<ModelImageResItem> getModelImageRes(){
		return modelImageRes;
	}
}