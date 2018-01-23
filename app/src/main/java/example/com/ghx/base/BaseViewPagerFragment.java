package example.com.ghx.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

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

    /**
     * 是否是第一次访问本页面<br/>
     * 考虑到ViewPager的预加载机制和回收导致的Fragment重用，这里mIsFirstVisit需要
     * 在onDestroyView中重置为true
     */
    protected boolean mIsFirstVisit=true;

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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //滑动到用户可见，并且是第一次访问本页面
        if(isVisibleToUser && mIsFirstVisit) {
            //当前没有硬盘缓存，也没有内存缓存数据
            if(!hasDiskCache() && !hasMemoryCache()){
                //请求网络数据
                lazyLoadRemoteData();
            }else{
                //加载缓存数据到UI
                lazyLoadCacheData();
            }
            mIsFirstVisit=false;
        }
        /*这种处理可能出现一种情况，即第一次进入，且无缓存时，请求网络数据，可能失败，
        但此时mIsFirstVisit依然置为了false，所以之后再进入此页面只能手动刷新，不会
        自动请求网络数据，不过影响不大。

        想要处理这种情况的话可以把第一个if改一下
        if(isVisibleToUser && mIsFirstVisit ||
             isVisibleToUser && !hasDiskCache() && !hasMemoryCache())
        这样即使不是第一次访问，但只要发现没缓存，就再请求网络数据。

        我这里先不改了*/

        /*我这里只做了页面数据的懒加载，如果要做视图的懒加载的话，可以结合ViewStub。
        只有第一次访问，才调用inflate，再创建个抽象方法，在if(isVisibleToUser
        && mIsFirstVisit)中调用即可*/

        /*我上面的懒加载逻辑，处理了Fragment重用时，利用缓存的情况，包括回收造成的重用，
        和ViewPager预加载机制造成的重用*/
    }

    /**
     * 当前是否有本地硬盘缓存数据
     * (没有硬盘缓存，默认返回false即可)
     * @return
     */
    protected abstract boolean hasDiskCache();

    /**
     * 当前是否有内存缓存数据
     * (若具有完整内存缓存数据，则返回true，否则返回false)
     * @return
     */
    protected abstract boolean hasMemoryCache();

    /**
     * 将缓存数据加载到UI上
     */
    protected abstract void lazyLoadCacheData();

    /**
     * 延迟请求网络数据
     */
    protected abstract void lazyLoadRemoteData();

    @Override
    @CallSuper
    public void onDestroyView() {
        super.onDestroyView();
        mIsFirstVisit=true;
    }

    /**
     * 显示吐司
     * @param text
     */
    public void showToast(String text){
        mToast.setText(text);
        mToast.show();
    }
}
