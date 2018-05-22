package vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBaseView;

@StateStrategyType(SkipStrategy.class)
public interface ILoginView extends IBaseView{

}
