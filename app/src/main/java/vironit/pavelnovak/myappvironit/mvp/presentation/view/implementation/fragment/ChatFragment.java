package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment;

import com.arellomobile.mvp.presenter.InjectPresenter;

import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.ChatPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base.BaseFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IChatFragment;

public class ChatFragment extends BaseFragment<ChatPresenter> implements IChatFragment {

    @InjectPresenter
    ChatPresenter mChatPresenter;

    public static ChatFragment getInstance(){
        return new ChatFragment();
    }


    @Override
    public int getLayoutResId() {
        return R.layout.layout_chat_fragment;
    }

    @Override
    protected ChatPresenter getPresenter() {
        return mChatPresenter;
    }
}
