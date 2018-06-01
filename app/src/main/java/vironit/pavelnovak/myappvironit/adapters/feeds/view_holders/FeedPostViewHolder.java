package vironit.pavelnovak.myappvironit.adapters.feeds.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.adapters.feeds.IItemFeed;
import vironit.pavelnovak.myappvironit.adapters.feeds.view_holders.base.BaseFeedViewHolder;
import vironit.pavelnovak.myappvironit.mvp.model.repository.feed.FeedPost;

public class FeedPostViewHolder extends BaseFeedViewHolder {

    @BindView(R.id.post_image)
    ImageView postImage;

    @BindView(R.id.post_title)
    TextView postTitle;

    @BindView(R.id.post_description)
    TextView postDescription;

    public FeedPostViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(IItemFeed typeFeedInterface) {
        postTitle.setText(((FeedPost) typeFeedInterface).getPostTitle());
        Glide.with(itemView.getContext())
                .load(((FeedPost) typeFeedInterface).getPostImageId())
                .into(postImage);
        postDescription.setText(((FeedPost) typeFeedInterface).getPostDescription());
    }
}
