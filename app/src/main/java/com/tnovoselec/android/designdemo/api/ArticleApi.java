package com.tnovoselec.android.designdemo.api;

import com.tnovoselec.android.designdemo.model.ArticleResponse;

import retrofit.http.GET;
import rx.Observable;

public interface ArticleApi {


  @GET("/svc/search/v2/articlesearch.json?q=new+york+times&sort=newest&api-key=3004f196a796792d1014c857af657567:11:72277667")
  Observable<ArticleResponse> listArticles();
}
