package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;

import com.arellomobile.mvp.InjectViewState;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.base.BaseActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IProfileFragment;
import vironit.pavelnovak.myappvironit.utils.AndroidVersionUtil;
import vironit.pavelnovak.myappvironit.utils.AppLog;

import static android.app.Activity.RESULT_OK;

@InjectViewState
public class ProfilePresenter extends BaseAppPresenter<IProfileFragment> {
    private static Fragment mRootFragment;

    private static final int REQUEST_IMAGE_CAPTURE_CAMERA = 1;

    private static final int REQUEST_IMAGE_CAPTURE_GALLERY = 2;

    private static final int REQUEST_CAMERA_PERMISSION = 3;

    private static final int REQUEST_GALLERY_PERMISSION = 4;

    private static final int REQUEST_OPEN_SETTINGS = 5;

    private String photoFilePath = "";

    public ProfilePresenter(){
        App.getAppComponent().inject(this);
    }

    public void changePhotoByCamera(@NonNull Fragment fragment) {
        mRootFragment = fragment;
        if (isPermissionGranted(Manifest.permission.CAMERA)){
            callCameraIntent();
        } else {
            requestPermission(
                    Manifest.permission.CAMERA,
                    REQUEST_CAMERA_PERMISSION,
                    "Камеры");
        }
    }

    public void changePhotoByGallery(@NonNull Fragment fragment) {
        mRootFragment = fragment;
        if (isPermissionGranted(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            callGalleryIntent();
        } else {
            requestPermission(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    REQUEST_GALLERY_PERMISSION,
                    "Галереи");
        }
    }

    private void callCameraIntent() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri outputUri = createImageUri();
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        mRootFragment.startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE_CAMERA);
    }

    private void callGalleryIntent() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        galleryIntent.setType("image/*");
        mRootFragment.startActivityForResult(
                Intent.createChooser(galleryIntent, "Select File"),
                REQUEST_IMAGE_CAPTURE_GALLERY);
    }

    private Uri createImageUri() {
        Uri imageURI;
        File imageFile = null;
        try {
            imageFile = createImageFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (AndroidVersionUtil.isApiVersionGraterOrEqual(24)) {
            imageURI = FileProvider.getUriForFile(
                    Objects.requireNonNull(mRootFragment.getContext()),
                    Objects.requireNonNull(mRootFragment.getActivity()).getApplicationContext().getPackageName() +
                            ".provider", imageFile);
        } else {
            imageURI = Uri.fromFile(imageFile);
        }
        return imageURI;
    }

    /*@Override
    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 Intent data,
                                 @NonNull BaseActivity baseActivity) {
        AppLog.logPresenter(this);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        super.onActivityResult(requestCode, resultCode, data, baseActivity);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_IMAGE_CAPTURE_CAMERA:
                    getViewState().setUserPhoto(photoFilePath, null);
                    break;
                case REQUEST_IMAGE_CAPTURE_GALLERY:
                    getViewState().setUserPhoto(null, data.getData());
                    break;
                case REQUEST_OPEN_SETTINGS:
                    break;
                default:
                    break;
            }
        }
    }*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data, @NonNull BaseActivity activity) {
        AppLog.logPresenter(this);
        super.onActivityResult(requestCode, resultCode, data, activity);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_IMAGE_CAPTURE_CAMERA:
                    getViewState().setUserPhoto(photoFilePath, null);
                    break;
                case REQUEST_IMAGE_CAPTURE_GALLERY:
                    getViewState().setUserPhoto(null, data.getData());
                    break;
                case REQUEST_OPEN_SETTINGS:
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults,
                                           @NonNull BaseActivity baseActivity) {
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callCameraIntent();
            } else {
//                Toast.makeText(
//                        baseActivity,
//                        "Разрешение на использование камеры отклонено",
//                        Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_GALLERY_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callGalleryIntent();
            } else {
//                Toast.makeText(
//                        baseActivity,
//                        "Разрешение на использование галереи отклонено",
//                        Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults, baseActivity);
        }
    }

    private boolean isPermissionGranted(String permission) {
        return ContextCompat.checkSelfPermission(
                mRootFragment.getContext(),
                permission) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission(String permission, int requestCode, String permissionName) {
        if (!mRootFragment.shouldShowRequestPermissionRationale(permission)) {
            getViewState().showMessage(
                    "Нет разрешения на использование " + permissionName,
                    false,
                    "Настройки",
                    v -> openApplicationSettings()
            );
        } else {
            mRootFragment.requestPermissions(new String[] {permission}, requestCode);
        }
    }

    private void openApplicationSettings() {
        Intent appSettingsIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + mRootFragment.getActivity().getPackageName()));
        mRootFragment.startActivityForResult(appSettingsIntent, REQUEST_OPEN_SETTINGS);
    }

    private File createImageFile() throws IOException {
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir = mRootFragment.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        photoFilePath = image.getAbsolutePath();
        return image;
    }

    @NonNull
    @Override
    public String getString(int strResId) {
        return null;
    }

    @NonNull
    @Override
    public String getString(int resId, @NonNull Object... formatArgs) {
        return null;
    }
}
