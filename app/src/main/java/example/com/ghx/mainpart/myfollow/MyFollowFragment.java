package example.com.ghx.mainpart.myfollow;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import example.com.ghx.BaseFragment;
import example.com.ghx.R;

/**
 * Created by gaohx on 2017/10/25.
 */

public class MyFollowFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    Unbinder unbinder;

    /**
     * 获取实例
     * @return
     */
    public static MyFollowFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MyFollowFragment fragment = new MyFollowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_test, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        mToolbar.setTitle("");
        ((AppCompatActivity)mActivity).setSupportActionBar(mToolbar);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public String getTabName(Context context) {
        return null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.my_follow,menu);
    }
}
