package com.tnovoselec.android.designdemo.model;

import com.google.gson.annotations.SerializedName;

public class Image {

  private static final String URL_PREFIX = "http://www.nytimes.com/";

  @SerializedName("url")
  public String url;

  @SerializedName("width")
  public int width;

  @SerializedName("height")
  public int height;

  public String buildUrl() {
    return URL_PREFIX + url;
  }
}
