package vironit.pavelnovak.myappvironit.adapters.feeds.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.adapters.feeds.IItemFeed;
import vironit.pavelnovak.myappvironit.adapters.feeds.view_holders.base.BaseFeedViewHolder;
import vironit.pavelnovak.myappvironit.mvp.model.repository.feed.FeedAd;

public class FeedAdViewHolder extends BaseFeedViewHolder {

    @BindView(R.id.ad_image)
    ImageView adImage;

    @BindView(R.id.ad_description)
    TextView adDescription;

    public FeedAdViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindView(IItemFeed typeFeedInterface) {
        Glide.with(itemView.getContext())
                .load(((FeedAd) typeFeedInterface).getAdImageId())
                .into(adImage);
        adDescription.setText(((FeedAd) typeFeedInterface).getDescription());
    }
}
