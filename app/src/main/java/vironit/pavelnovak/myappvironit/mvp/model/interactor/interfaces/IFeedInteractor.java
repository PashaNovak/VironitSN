package vironit.pavelnovak.myappvironit.mvp.model.interactor.interfaces;

import io.reactivex.Single;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Data;

public interface IFeedInteractor {

    Single<Data> getFeeds(int page, int pageSize);
}
