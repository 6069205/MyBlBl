package example.com.ghx.mainpart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.ghx.base.BaseActivity;
import example.com.ghx.base.BaseFragment;
import example.com.ghx.R;
import example.com.ghx.mainpart.home.HomeFragment;
import example.com.ghx.mainpart.myfollow.MyFollowFragment;

/**
 *
 * @author gaohx
 * @date 2017/12/19
 */
public class MainPartActivity extends BaseActivity {
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    /**
     * fragment列表<br/>
     * (顺序与抽屉菜单一致，若某个抽屉菜单点击后不是显示Fragment，则在对应位置存null)
     */
    private ArrayList<BaseFragment> mFragmentList;
    /**
     * menu item的ID列表(与fragment列表顺序对应)
     */
    private ArrayList<Integer> mMenuIdList;
    /**
     * 当前展示的Fragment页面索引(未展示时默认值为-1)
     */
    private int mCurShowFragmentIndex = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_part);
        ButterKnife.bind(this);

        mNavigationView.setNavigationItemSelectedListener(mOnMenuListener);
        mFragmentList = new ArrayList<>(9);
        mMenuIdList = new ArrayList<>(9);

        FragmentManager fm = getSupportFragmentManager();
        //TODO
        /**
         * 先从管理器中找Fragment，这样做是为了应用被回收时，能够拿到原先的fragment，
         * 而不是重新new，才能真正恢复现场。(这个之后测试一下，以前弄过，现在忘了)
         * (而且貌似被回收后，回来所有fragment都会被展示出来，需要我们先把所有fragment都隐藏后，
         * 展示回收时保存的当前页面号对应的fragment)
         */
        //主页
        HomeFragment homeFragment;
        homeFragment = (HomeFragment) fm.findFragmentByTag(HomeFragment.class.getName());
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
        }
        mFragmentList.add(homeFragment);
        mMenuIdList.add(R.id.action_main_part_home);

        //我的关注
        MyFollowFragment myFollowFragment;
        myFollowFragment = (MyFollowFragment) fm.findFragmentByTag(MyFollowFragment.class.getName());
        if (myFollowFragment == null) {
            myFollowFragment = MyFollowFragment.newInstance();
        }
        mFragmentList.add(myFollowFragment);
        mMenuIdList.add(R.id.action_main_part_my_follow);

        //发生了回收
        if (savedInstanceState != null) {
            //拿到回收前保存的mCurShowFragmentIndex
            mCurShowFragmentIndex = savedInstanceState.getInt("curShowFragmentIndex");
        }

        if (mCurShowFragmentIndex == -1) {
            //首次默认展示主页
            showFragment(0);
            //设置menu选中主页
            mNavigationView.setCheckedItem(mMenuIdList.get(0));
        } else {
            //展示其它页面
            showFragment(mCurShowFragmentIndex);
            //设置menu选中位置mCurShowFragmentIndex
            mNavigationView.setCheckedItem(mMenuIdList.get(mCurShowFragmentIndex));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("curShowFragmentIndex", mCurShowFragmentIndex);
        super.onSaveInstanceState(outState);
    }

    /**
     * 展示指定的Fragment页面
     *
     * @param index
     */
    private void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (mCurShowFragmentIndex != -1) {
            //隐藏上一个显示的Fragment
            BaseFragment prevFragment = mFragmentList.get(mCurShowFragmentIndex);
            ft.hide(prevFragment);
        }

        //显示当前要展示的Fragment
        BaseFragment nextFragment = mFragmentList.get(index);
        //若未被添加则先add
        if (!nextFragment.isAdded()) {
            ft.add(R.id.container, nextFragment, nextFragment.getClass().getName());
        }
        //显示
        ft.show(nextFragment);

        ft.commit();

        //保存新的当前页索引
        mCurShowFragmentIndex = index;
    }

    /**
     * NavigationView上的menu item点击监听
     */
    private NavigationView.OnNavigationItemSelectedListener mOnMenuListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    item.setChecked(true);
                    int index = 0;
                    for (int i = 0; i < mMenuIdList.size(); i++) {
                        if (item.getItemId() == mMenuIdList.get(i)) {
                            index = i;
                            break;
                        }
                    }
                    showFragment(index);
                    mDrawerLayout.closeDrawer(mNavigationView,true);
                    return true;
                }
            };

}
