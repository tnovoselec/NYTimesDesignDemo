package com.tnovoselec.android.designdemo.model;

import com.google.gson.annotations.SerializedName;
import com.tnovoselec.android.designdemo.util.ListUtils;

import java.util.List;

public class Article {

  @SerializedName("snippet")
  public String snippet;

  @SerializedName("headline")
  public Headline headline;

  @SerializedName("multimedia")
  public List<Image> images;

  public boolean hasImages(){
    return !ListUtils.isEmpty(images);
  }
}
