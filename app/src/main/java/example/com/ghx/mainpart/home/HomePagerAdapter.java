package example.com.ghx.mainpart.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import example.com.ghx.base.BaseViewPagerFragment;

/**
 * 主页ViewPager适配器
 * @author gaohx
 * @date 2017/12/19
 */
public class HomePagerAdapter extends FragmentPagerAdapter{

    private Context mContext;
    private List<BaseViewPagerFragment> mList;

    public HomePagerAdapter(Context context, FragmentManager fm, List<BaseViewPagerFragment> list) {
        super(fm);
        mContext=context;
        mList=list;
        if(mList==null){
            mList=new ArrayList<>(0);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).getTabName(mContext);
    }
}
