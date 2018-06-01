package vironit.pavelnovak.myappvironit.mvp.model.repository.feed;

import vironit.pavelnovak.myappvironit.adapters.feeds.IItemFeed;
import vironit.pavelnovak.myappvironit.adapters.feeds.TypeFeedEnum;

public class FeedAd implements IItemFeed {

    private String description;
    private int adImageId;

    public FeedAd(String description, int adImageId) {
        this.description = description;
        this.adImageId = adImageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAdImageId() {
        return adImageId;
    }

    public void setAdImageId(int adImageId) {
        this.adImageId = adImageId;
    }

    @Override
    public TypeFeedEnum getItemFeedType() {
        return TypeFeedEnum.AD;
    }
}
