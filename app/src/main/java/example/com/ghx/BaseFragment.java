package example.com.ghx;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gaohx on 2017/10/17.
 */

public abstract class BaseFragment extends Fragment{
    int a=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getTabName(getActivity()),"onCreate-ghxa");
        a=8888;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(getTabName(getActivity()),"onCreateView-ghxa"+"-"+a);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(getTabName(getActivity()),"onStart-ghxa");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.d(getTabName(getActivity()),"onStop-ghxa");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(getTabName(context),"onAttach-ghxa");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(getTabName(getActivity()),"onDetach-ghxa");
    }

    /**
     * 获取Fragment对应的名称<br/>
     * (Fragment联合ViewPager、联合TabLayout时，作为Tab名称使用)<br/>
     * @param context
     * @return
     */
    public abstract String getTabName(Context context);
}
