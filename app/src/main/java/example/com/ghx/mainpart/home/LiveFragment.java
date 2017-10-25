package example.com.ghx.mainpart.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.ghx.BaseFragment;
import example.com.ghx.R;

/**
 * 首页直播Fragment
 * Created by gaohx on 2017/10/19.
 */

public class LiveFragment extends BaseFragment{
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
        return context.getResources().getString(R.string.home_tab_live);
    }
}
