package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.constants.IAppConstants;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.IGoogleMapsView;

@InjectViewState
public class GoogleMapsPresenter extends BaseAppPresenter<IGoogleMapsView> implements OnCompleteListener {

    public GoogleMapsPresenter() {
        App.getAppComponent().inject(this);
    }

    public void getDeviceLocation(@NonNull Activity activity) {
        FusedLocationProviderClient mFusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(activity);
        try {
            Task location = mFusedLocationProviderClient.getLastLocation();
            location.addOnCompleteListener(this);
        } catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete(@NonNull Task task) {
        if (task.isSuccessful()){
            Location location = (Location) task.getResult();
            getViewState().moveMapCamera(new LatLng(location.getLatitude(), location.getLongitude()),
                    IAppConstants.DEFAULT_GOOGLE_MAP_CAMERA_ZOOM,
                    getString(R.string.current_device_location_message));
        } else {
            getViewState().showAutocloseableMessage(getString(R.string.unknown_device_loation));
        }
    }

    public void geoLocate(@Nullable String searchMessage, Activity activity){
        getViewState().hideKeyboard();
        Geocoder geocoder = new Geocoder(activity);
        List<Address> addresses = new ArrayList<>();
        try {
            addresses = geocoder.getFromLocationName(searchMessage, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addresses.size() > 0) {
            Address searchingAddress = addresses.get(0);
            getViewState().moveMapCamera(
                    new LatLng(searchingAddress.getLatitude(), searchingAddress.getLongitude()),
                    IAppConstants.DEFAULT_GOOGLE_MAP_CAMERA_ZOOM,
                    searchingAddress.getAddressLine(0)
            );
        }
    }
}
