package com.tnovoselec.android.designdemo.api;

import com.tnovoselec.android.designdemo.model.ArticleResponse;

import retrofit.RestAdapter;
import rx.Observable;

public class ArticleService {

  private static final String BASE_URL = "http://api.nytimes.com";

  private ArticleApi articleApi;

  private static final ArticleService INSTANCE = new ArticleService();

  public static ArticleService getInstance() {
    return INSTANCE;
  }

  private ArticleService() {


    RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint(BASE_URL)
        .build();
    articleApi = restAdapter.create(ArticleApi.class);
  }

  public Observable<ArticleResponse> listArticles() {
    return articleApi.listArticles();
  }

}
