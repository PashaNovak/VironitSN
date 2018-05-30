package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment;

import android.net.Uri;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;

import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.ProfilePresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base.BaseFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IProfileFragment;

public class ProfileFragment extends BaseFragment<ProfilePresenter> implements IProfileFragment{

    @InjectPresenter
    ProfilePresenter mProfilePresenter;



    public static ProfileFragment getInstance(){
        return new ProfileFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.layout_profile_fragment;
    }

    @Override
    protected ProfilePresenter getPresenter() {
        return mProfilePresenter;
    }

    @Override
    public void setUserPhoto(String photoPath, Uri photoUri) {
        if (photoPath != null || photoUri != null){
            if (photoUri != null){
               // Glide.with(this).load(photoUri).into();
            }
        }
    }


}
