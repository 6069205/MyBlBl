package example.com.ghx.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.ghx.BaseActivity;
import example.com.ghx.BaseFragment;
import example.com.ghx.R;

/**
 * Created by gaohx on 2017/10/17.
 */

public class HomeActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    private HomePagerAdapter mPagerAdapter;
    private List<BaseFragment> mFragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        this.setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(mOnMenuItemClickListener);

        mFragmentList =new ArrayList<>(4);
        mFragmentList.add(new LiveFragment());
        mFragmentList.add(new RecommendFragment());
        mFragmentList.add(new FollowPlayFragment());
        mFragmentList.add(new SpecialColumnFragment());
        mPagerAdapter=new HomePagerAdapter(getApplicationContext()
                ,getSupportFragmentManager(),mFragmentList);
        viewpager.setAdapter(mPagerAdapter);

        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    private Toolbar.OnMenuItemClickListener mOnMenuItemClickListener=new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Log.d("11111111", "ghxa");
            return false;
        }
    };
}
