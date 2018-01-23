package example.com.ghx.mainpart.home.live;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import example.com.ghx.base.BaseViewPagerFragment;
import example.com.ghx.R;
import example.com.ghx.di.FragmentScope;

/**
 * 首页直播Fragment
 * @author gaohx
 * @date 2017/12/19
 */
@FragmentScope
public class LiveFragment extends BaseViewPagerFragment {

    @Inject
    public LiveFragment(){}

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
        return context.getResources().getString(R.string.home_tab_live);
    }

    @Override
    protected boolean hasDiskCache() {
        return false;
    }

    @Override
    protected boolean hasMemoryCache() {
        return false;
    }

    @Override
    protected void lazyLoadCacheData() {

    }

    @Override
    protected void lazyLoadRemoteData() {

    }
}
