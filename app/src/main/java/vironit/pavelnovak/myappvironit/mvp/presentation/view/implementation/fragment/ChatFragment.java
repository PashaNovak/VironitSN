package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment;

import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.ChatPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base.BaseFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IChatFragment;

public class ChatFragment extends BaseFragment<ChatPresenter> implements IChatFragment {

    @InjectPresenter
    ChatPresenter mChatPresenter;

    @BindView(R.id.go_to_google_map_btn)
    Button button;

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

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            button.setOnClickListener(v -> mChatPresenter.GoToGoogleMap(this.getContext()));
        }
    }
}
