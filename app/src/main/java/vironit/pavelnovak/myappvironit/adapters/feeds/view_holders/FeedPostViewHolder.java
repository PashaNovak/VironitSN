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
import vironit.pavelnovak.myappvironit.mvp.model.repository.feed.FeedPost;

public class FeedPostViewHolder extends BaseViewHolder<Article> {

    @BindView(R.id.post_image)
    ImageView postImage;

    @BindView(R.id.post_title)
    TextView postTitle;

    @BindView(R.id.post_description)
    TextView postDescription;

    public FeedPostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindView(Article article) {
        postTitle.setText(article.getTitle());
        postDescription.setText(article.getDescription());
        Glide.with(itemView.getContext())
                .load(article.getUrlToImage())
                .into(postImage);
    }
}
