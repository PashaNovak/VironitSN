package vironit.pavelnovak.myappvironit.mvp.model.repository.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import vironit.pavelnovak.myappvironit.adapters.feeds.IItemFeed;
import vironit.pavelnovak.myappvironit.adapters.feeds.TypeFeedEnum;

public class Article implements IItemFeed {
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    public Source getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    @Override
    public TypeFeedEnum getItemFeedType() {
        return TypeFeedEnum.POST;
    }
}
