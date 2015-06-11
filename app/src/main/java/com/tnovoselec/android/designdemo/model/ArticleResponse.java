package com.tnovoselec.android.designdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponse {

  @SerializedName("response")
  public Response response;

  public class Response{

    @SerializedName("docs")
    public List<Article> articles;
  }
}
