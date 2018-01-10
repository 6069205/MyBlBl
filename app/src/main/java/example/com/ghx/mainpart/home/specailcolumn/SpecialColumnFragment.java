package example.com.ghx.mainpart.home.specailcolumn;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import example.com.ghx.BaseFragment;
import example.com.ghx.BaseViewPagerFragment;
import example.com.ghx.R;
import example.com.ghx.di.FragmentScope;

/**
 * 首页专栏Fragment
 * Created by gaohx on 2017/10/20.
 */
@FragmentScope
public class SpecialColumnFragment extends BaseViewPagerFragment {

    @Inject
    public SpecialColumnFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        return view;
    }

    @Override
    public String getTabName(Context context) {
        return context.getResources().getString(R.string.home_tab_special_column);
    }

    @Override
    protected void lazyLoad() {

    }
}
