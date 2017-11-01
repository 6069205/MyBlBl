package example.com.ghx.mainpart.home.recommend;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.ghx.BaseFragment;
import example.com.ghx.BaseViewPagerFragment;
import example.com.ghx.R;

/**
 * 首页推荐Fragment
 * Created by gaohx on 2017/10/20.
 */

public class RecommendFragment extends BaseViewPagerFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        return view;
    }

    @Override
    public String getTabName(Context context) {
        return context.getResources().getString(R.string.home_tab_recommend);
    }

    @Nullable
    @Override
    protected Toolbar getToolBar() {
        return null;
    }

    @Override
    protected void lazyLoad() {

    }
}
