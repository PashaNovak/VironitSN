package vironit.pavelnovak.myappvironit.mvp.model.manager.implementation.network;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import vironit.pavelnovak.myappvironit.BuildConfig;

public class HeaderInterceptor implements Interceptor {
    @Inject
    public HeaderInterceptor(){

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder mBuilder = originalRequest.newBuilder();

        mBuilder.header("Authorization","Bearer "+ BuildConfig.FEEDS_API_KEY);
        return chain.proceed(mBuilder.build());
    }
}
