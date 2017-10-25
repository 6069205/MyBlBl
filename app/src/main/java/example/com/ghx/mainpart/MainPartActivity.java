package example.com.ghx.mainpart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.ghx.BaseActivity;
import example.com.ghx.BaseFragment;
import example.com.ghx.R;
import example.com.ghx.mainpart.home.HomeFragment;

/**
 * Created by gaohx on 2017/10/17.
 */

public class MainPartActivity extends BaseActivity {
    @BindView(R.id.navigationview)
    NavigationView mNavigationview;
    /**
     * fragment列表<br/>
     * (顺序与抽屉菜单一致，若某个抽屉菜单点击后不是显示Fragment，则在对应位置存null)
     */
    private ArrayList<BaseFragment> mFragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_part);
        ButterKnife.bind(this);

        mFragmentList = new ArrayList<>(9);
//        mFragmentList.add()
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, homeFragment, homeFragment.mTag).commit();
    }
}
