package example.com.ghx.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页ViewPager适配器
 * Created by gaohx on 2017/10/19.
 */

public class HomePagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> mList;

    public HomePagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
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
        return "页面"+position;
    }
}
