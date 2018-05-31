package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment;

import android.net.Uri;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.ProfilePresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base.BaseFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.view.ProfileAvatar;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IProfileFragment;

public class ProfileFragment extends BaseFragment<ProfilePresenter> implements IProfileFragment{

    @InjectPresenter
    ProfilePresenter mProfilePresenter;

    @OnClick(R.id.i_btn_change_photo_by_camera)
    void changeProfilePhotoByCamera(){
        mProfilePresenter.changePhotoByCamera(this);
    }

    @OnClick(R.id.i_btn_change_photo_by_gallery)
    void changeProfilePhotoByGallery(){
        mProfilePresenter.changePhotoByGallery(this);
    }

    @BindView(R.id.profile_photo)
    ProfileAvatar profilePhoto;

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
                Glide.with(this).load(photoUri).into(profilePhoto);
            } else Glide.with(this).load(photoPath).into(profilePhoto);
        }
    }


}
