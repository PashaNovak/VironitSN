package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.adapters.map.PlaceAutocompleteAdapter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.GoogleMapsPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.base.BaseActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.IGoogleMapsView;

public class GoogleMapsActivity extends BaseActivity<GoogleMapsPresenter> implements IGoogleMapsView,
        OnMapReadyCallback,
        TextView.OnEditorActionListener,
        View.OnClickListener,
        GoogleApiClient.OnConnectionFailedListener {

    @InjectPresenter
    GoogleMapsPresenter mGoogleMapsPresenter;

    @BindView(R.id.edt_search_input_google_maps)
    AutoCompleteTextView mSearchInputGoogleMaps;

    @BindView(R.id.i_btn_get_device_current_position)
    ImageButton mCurrentDevisePositionButton;

    @BindView(R.id.iv_cancel_search_icon_view)
    ImageView mCleanSearchTextButton;

    private static final LatLngBounds LAT_LNG_BOUNDS = new LatLngBounds(new LatLng(-40, -168), new LatLng(71, 136));

    private GoogleMap mGoogleMap;

    private GoogleApiClient mGoogleApiClient;

    private PlaceAutocompleteAdapter mPlaceAutocompleteAdapter;

    public static void start(@Nullable Context context){
        if (context != null){
            context.startActivity(new Intent(context, GoogleMapsActivity.class));
        }
    }

    @Override
    protected void initViewBeforePresenterAttach() {
        super.initViewBeforePresenterAttach();
        mCleanSearchTextButton.setOnClickListener(this);
        mCurrentDevisePositionButton.setOnClickListener(this);
        initMap();
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map_fragment);
        mapFragment.getMapAsync(this);
        initMapSearchBar();
        //mCurrentDevisePositionButton.setOnClickListener(this);
    }

    private void initMapSearchBar() {
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();
        mPlaceAutocompleteAdapter = new PlaceAutocompleteAdapter(
                this,
                Places.getGeoDataClient(this, null),
                LAT_LNG_BOUNDS,
                null
        );
        mSearchInputGoogleMaps.setAdapter(mPlaceAutocompleteAdapter);
        mSearchInputGoogleMaps.setOnEditorActionListener(this);
        mSearchInputGoogleMaps.setOnClickListener(this);
    }

    @Override
    protected GoogleMapsPresenter getPresenter() {
        return mGoogleMapsPresenter;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.layout_google_map_activity;
    }

    @Override
    public int getRootViewResId() {
        return R.id.v_root_google_map_activity;
    }

    @Override
    public void moveMapCamera(LatLng latLng, float zoom, @Nullable String titleString) {
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
        if (titleString != null && !titleString.equals(getString(R.string.current_device_location_message))) {
            MarkerOptions currentMarker = new MarkerOptions()
                    .position(latLng)
                    .title(titleString);
            mGoogleMap.addMarker(currentMarker);
        }
    }

    @Override
    public void moveMapCameraToDeviceLocation() {
        mGoogleMapsPresenter.getDeviceLocation(this);
        try {
            mGoogleMap.setMyLocationEnabled(true);
            mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.i_btn_get_device_current_position:
                moveMapCameraToDeviceLocation();
                break;
            case R.id.google_map_fragment:
                hideKeyboard();
                break;
            case R.id.iv_cancel_search_icon_view:
                mSearchInputGoogleMaps.setText("");
                break;
            default :
                hideKeyboard();
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH
                || actionId == EditorInfo.IME_ACTION_DONE
                || event.getAction() == KeyEvent.ACTION_DOWN
                || event.getAction() == KeyEvent.KEYCODE_ENTER) {
            mGoogleMapsPresenter.geoLocate(mSearchInputGoogleMaps.getText().toString(), this);
        }
        return false;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
    }
}
