package com.tnovoselec.android.designdemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tnovoselec.android.designdemo.api.ArticleService;
import com.tnovoselec.android.designdemo.model.Article;
import com.tnovoselec.android.designdemo.model.ArticleResponse;
import com.tnovoselec.android.designdemo.ui.adapter.NewsListAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class NewsListActivity extends AppCompatActivity {

  @InjectView(R.id.drawer_layout)
  DrawerLayout drawerLayout;

  @InjectView(R.id.toolbar)
  Toolbar toolbar;

  @InjectView(R.id.news_list)
  RecyclerView recyclerView;

  @InjectView(R.id.navigation_view)
  NavigationView navigationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news_list);
    ButterKnife.inject(this);

    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    setupDrawerContent(navigationView);
    requestData();
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        drawerLayout.openDrawer(GravityCompat.START);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }


  private void setupDrawerContent(NavigationView navigationView) {
    navigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();
            return true;
          }
        });
  }

  private void requestData() {
    ArticleService.getInstance()
        .listArticles()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<ArticleResponse>() {
          @Override
          public void call(ArticleResponse articleResponse) {
            fillViews(articleResponse.response.articles);
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {
            throwable.printStackTrace();
          }
        });
  }

  private void fillViews(List<Article> articles) {
    recyclerView.setAdapter(new NewsListAdapter(this, articles));
  }

}
