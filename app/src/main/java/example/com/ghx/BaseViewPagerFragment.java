package example.com.ghx;

/**
 * Created by gaohx on 2017/11/1.
 */

public abstract class BaseViewPagerFragment extends BaseFragment{
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
}
