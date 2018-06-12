package vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment;

import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Article;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Data;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.IAddListData;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBasePaginationView;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBaseView;

public interface IFeedFragment extends IBasePaginationView, IAddListData<Article> {

}
