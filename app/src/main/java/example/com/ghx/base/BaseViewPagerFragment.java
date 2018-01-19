package example.com.ghx.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import example.com.ghx.application.MyApplication;

/**
 * ViewPager中使用的Fragment基类
 * @author gaohx
 * @date 2017/12/19
 */
public abstract class BaseViewPagerFragment extends DaggerFragment {
//    /**
//     * 类名作为TAG
//     */
//    public String TAG;

    protected Activity mActivity;
    @Inject
    protected Toast mToast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
    }

    /**
     * 获取Fragment对应的名称<br/>
     * (Fragment联合ViewPager、联合TabLayout时，作为Tab名称使用)<br/>
     * @param context
     * @return
     */
    public abstract String getTabName(Context context);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {//对应getUserVisibleHint可以获取
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser) {
            lazyLoad();
        }
    }

    /**
     * 延迟加载<br/>
     * (是要请求数据，还是用原来的缓存数据，这个判断，就到子类中看需求来做了)
     */
    protected abstract void lazyLoad();

    /**
     * 显示吐司
     * @param text
     */
    public void showToast(String text){
        mToast.setText(text);
        mToast.show();
    }
}
