package vironit.pavelnovak.myappvironit.mvp.model.repository;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Data;

public interface ApiInterface {

    @GET("top-headlines")
    Single<Data> getNews(@Query("country") String countryCode);
}
