package vironit.pavelnovak.myappvironit.mvp.model.interactor.implementation;

import javax.inject.Inject;

import io.reactivex.Single;
import vironit.pavelnovak.myappvironit.mvp.model.interactor.interfaces.IFeedInteractor;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Data;
import vironit.pavelnovak.myappvironit.mvp.model.repository.interfaces.IFeedRepository;

public class FeedInteractorImpl implements IFeedInteractor{
    private final IFeedRepository mIFeedRepository;

    @Inject
    public FeedInteractorImpl(IFeedRepository mFeedRepository) {
        this.mIFeedRepository = mFeedRepository;
    }

    @Override
    public Single<Data> getFeeds(int page, int perPage) {
        return mIFeedRepository.getFeeds("ru", page, perPage);
    }
}
