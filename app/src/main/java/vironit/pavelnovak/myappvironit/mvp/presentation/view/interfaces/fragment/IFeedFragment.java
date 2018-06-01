package vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment;

import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Data;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBaseView;

public interface IFeedFragment extends IBaseView {
    void onGetDataSuccess(Data newsFeedData);
    void onGetDataFailure();
    void setLoadingSpinnerState(int visibility);
}
