package vironit.pavelnovak.myappvironit.mvp.model.repository.interfaces;

import io.reactivex.Single;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Data;

public interface IFeedRepository {

    Single<Data> getFeeds(String countryCode, int page, int perPage);
}
