package vironit.pavelnovak.myappvironit.mvp.model.repository.feed;

import vironit.pavelnovak.myappvironit.adapters.feeds.IItemFeed;
import vironit.pavelnovak.myappvironit.adapters.feeds.TypeFeedEnum;

public class FeedPost implements IItemFeed {

    private String postTitle;
    private String postDescription;
    private String postImageId;

    public FeedPost(String postTitle, String postDescription, String postImageId) {
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postImageId = postImageId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostImageId() {
        return postImageId;
    }

    public void setPostImageId(String postImageId) {
        this.postImageId = postImageId;
    }

    @Override
    public TypeFeedEnum getItemFeedType() {
        return TypeFeedEnum.POST;
    }
}
