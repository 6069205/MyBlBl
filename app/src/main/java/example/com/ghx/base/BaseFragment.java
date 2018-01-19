package example.com.ghx.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import example.com.ghx.application.MyApplication;

/**
 *
 * @author gaohx
 * @date 2017/12/19
 */
public abstract class BaseFragment extends DaggerFragment{
//    /**
//     * 类名作为TAG
//     */
//    public String TAG;

    protected Activity mActivity;
    protected Toolbar mTb;

    @Inject
    protected Toast mToast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
//        TAG =getClass().getName();
    }

    @Override
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //TODO 之后在父类方法这里添加support包中的注解，让子类必须调用父类这个方法，已加
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
     * 返回Fragment页面的ToolBar
     * @return
     */
    protected abstract @Nullable Toolbar getToolBar();

    /**
     * 显示吐司
     * @param text
     */
    public void showToast(String text){
        mToast.setText(text);
        mToast.show();
    }
}
