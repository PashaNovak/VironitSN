package vironit.pavelnovak.myappvironit.mvp.model.repository.implementation;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import vironit.pavelnovak.myappvironit.constants.IAppConstants;
import vironit.pavelnovak.myappvironit.mvp.model.repository.ApiInterface;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Data;
import vironit.pavelnovak.myappvironit.mvp.model.repository.interfaces.IFeedRepository;

public class FeedRepositoryImpl implements IFeedRepository {

    private final ApiInterface mApiInterface;
    private final Scheduler mIOScheduler;

    @Inject
    public FeedRepositoryImpl(ApiInterface mApiInterface, @Named(IAppConstants.IO_SCHEDULER) Scheduler mIOScheduler) {
        this.mApiInterface = mApiInterface;
        this.mIOScheduler = mIOScheduler;
    }

    @Override
    public Single<Data> getFeeds(String countryCode) {
        return mApiInterface.getNews(countryCode)
                .subscribeOn(mIOScheduler);
    }
}
