package com.tnovoselec.android.designdemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tnovoselec.android.designdemo.R;
import com.tnovoselec.android.designdemo.model.Article;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ArticleViewHolder> {

  private final List<Article> articles;
  private final Context context;

  public NewsListAdapter(Context context, List<Article> articles) {
    this.articles = articles;
    this.context = context;
  }

  @Override
  public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_news_list, parent, false);
    return new ArticleViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ArticleViewHolder holder, int position) {
    Article article = articles.get(position);
    holder.headline.setText(article.headline.headline);
    if (article.hasImages()) {
      Picasso.with(context).load(article.images.get(0).buildUrl()).into(holder.image);
    }
  }

  @Override
  public int getItemCount() {
    return articles.size();
  }

  public static class ArticleViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.news_list_item_headline)
    TextView headline;

    @InjectView(R.id.news_list_item_image)
    ImageView image;

    public ArticleViewHolder(View itemView) {
      super(itemView);
      ButterKnife.inject(this, itemView);
    }
  }
}
