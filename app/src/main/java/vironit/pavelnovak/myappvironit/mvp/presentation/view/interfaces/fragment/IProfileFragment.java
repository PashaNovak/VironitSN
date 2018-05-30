package vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment;

import android.net.Uri;

import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBaseView;

public interface IProfileFragment extends IBaseView {
    void setUserPhoto(String photoPath, Uri photoUri);
}
