package example.com.ghx.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import example.com.ghx.BaseFragment;
import example.com.ghx.R;

/**
 * Created by gaohx on 2017/10/17.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    Unbinder unbinder;

    private HomePagerAdapter mPagerAdapter;
    private List<BaseFragment> mFragmentList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        mToolbar.setTitle("");
        ((AppCompatActivity)mActivity).setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(mOnMenuItemClickListener);

        mFragmentList = new ArrayList<>(4);
        mFragmentList.add(new LiveFragment());
        mFragmentList.add(new RecommendFragment());
        mFragmentList.add(new FollowPlayFragment());
        mFragmentList.add(new SpecialColumnFragment());
        mPagerAdapter = new HomePagerAdapter(mActivity
                , getChildFragmentManager(), mFragmentList);
        mViewpager.setAdapter(mPagerAdapter);

        mTabLayout.setupWithViewPager(mViewpager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public String getTabName(Context context) {
        return null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home, menu);
    }

    private Toolbar.OnMenuItemClickListener mOnMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Log.d("11111111", "ghxa");
            return false;
        }
    };


}
