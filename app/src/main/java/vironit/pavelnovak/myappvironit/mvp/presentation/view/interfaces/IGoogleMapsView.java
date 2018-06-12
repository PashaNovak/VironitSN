package vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces;

import android.support.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBaseView;

public interface IGoogleMapsView extends IBaseView {

    void moveMapCamera(LatLng latLng, float zoom, @Nullable String titleString);
    void moveMapCameraToDeviceLocation();
}
