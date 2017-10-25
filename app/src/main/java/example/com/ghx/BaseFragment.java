package example.com.ghx;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by gaohx on 2017/10/17.
 */

public abstract class BaseFragment extends Fragment{

    public String mTag;
    protected Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
        mTag=getClass().getName();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    /**
     * 获取Fragment对应的名称<br/>
     * (Fragment联合ViewPager、联合TabLayout时，作为Tab名称使用)<br/>
     * @param context
     * @return
     */
    public abstract String getTabName(Context context);
}
