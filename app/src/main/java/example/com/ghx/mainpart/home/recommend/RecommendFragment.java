package example.com.ghx.mainpart.home.recommend;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import example.com.ghx.base.BaseViewPagerFragment;
import example.com.ghx.R;

/**
 * 首页推荐Fragment
 * @author gaohx
 * @date 2017/12/19
 */
public class RecommendFragment extends BaseViewPagerFragment
        implements RecommendContract.View{

    @Inject
    protected RecommendContract.Presenter mPresenter;

    public RecommendFragment(){}

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
        showToast("有缓存，加载缓存数据");
    }

    @Override
    protected void lazyLoadRemoteData() {
        showToast("无缓存，请求网络数据");
    }

    @Override
    public void refreshList() {

    }

    @Override
    public void showMessage(String message) {
        showToast(message);
    }
}
