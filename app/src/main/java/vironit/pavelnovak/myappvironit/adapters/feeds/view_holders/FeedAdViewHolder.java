package vironit.pavelnovak.myappvironit.adapters.feeds.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.adapters.feeds.IItemFeed;
import vironit.pavelnovak.myappvironit.adapters.base.base_view_holders.BaseViewHolder;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Article;
import vironit.pavelnovak.myappvironit.mvp.model.repository.feed.FeedAd;

public class FeedAdViewHolder extends BaseViewHolder<Article> {

    @BindView(R.id.ad_image)
    ImageView adImage;

    @BindView(R.id.ad_description)
    TextView adDescription;

    public FeedAdViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindView(Article article) {
        Glide.with(itemView.getContext())
                .load(article.getUrlToImage())
                .into(adImage);
        adDescription.setText(article.getDescription());
    }
}
