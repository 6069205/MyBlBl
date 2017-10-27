package example.com.ghx;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gaohx on 2017/10/17.
 */

public abstract class BaseFragment extends Fragment{
//    /**
//     * 类名作为TAG
//     */
//    public String TAG;
    protected Activity mActivity;
    protected Toolbar mTb;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
//        TAG =getClass().getName();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mTb=getToolBar();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        //若Fragment从隐藏转为显示
        if(!hidden && mTb!=null){
            //重新设置SupportActionBar
            ((AppCompatActivity)mActivity).setSupportActionBar(mTb);
        }
    }

    /**
     * 获取Fragment对应的名称<br/>
     * (Fragment联合ViewPager、联合TabLayout时，作为Tab名称使用)<br/>
     * @param context
     * @return
     */
    public abstract String getTabName(Context context);

    /**
     * 返回Fragment页面的ToolBar
     * @return
     */
    protected abstract @Nullable Toolbar getToolBar();
}
