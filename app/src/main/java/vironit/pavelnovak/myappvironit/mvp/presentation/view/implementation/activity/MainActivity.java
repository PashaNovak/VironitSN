package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.CompanyDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.DepartmentDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.EmployeeDB;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.entity.InsuranceDB;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.MainPresenter;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.base.BaseActivityWithFragments;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.ChatFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.FeedFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.ProfileFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.IMainView;

public class MainActivity extends BaseActivityWithFragments<MainPresenter> implements IMainView, BottomNavigationView.OnNavigationItemSelectedListener {

    @InjectPresenter
    MainPresenter mMainPresenter;

    @BindView(R.id.navigation_bottom_view)
    BottomNavigationView bottomNavigationView;

    @Override
    public int getLayoutResId() {
        return R.layout.layout_main_activity;
    }

    @Override
    public int getRootViewResId() {
        return R.id.v_root_main_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showSelectedFragment(FeedFragment.getInstance());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        mMainPresenter.addData();
    }

    public static void start(@Nullable Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, MainActivity.class));
        }
    }

    @Override
    protected MainPresenter getPresenter() {
        return mMainPresenter;
    }

    @Override
    public void showSelectedFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_home_frame_layout, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_menu_profile:
                showSelectedFragment(ProfileFragment.getInstance());
                return true;
            case R.id.action_menu_feed:
                showSelectedFragment(FeedFragment.getInstance());
                return true;
            case R.id.action_menu_chat:
                showSelectedFragment(ChatFragment.getInstance());
                return true;
            default:
                return false;
        }
    }
}
