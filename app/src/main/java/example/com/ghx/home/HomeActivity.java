package example.com.ghx.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeFragment homeFragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,homeFragment,homeFragment.mTag).commit();
    }
}
