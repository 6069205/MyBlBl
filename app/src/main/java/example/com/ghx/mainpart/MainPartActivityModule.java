package example.com.ghx.mainpart;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import example.com.ghx.di.FragmentScope;
import example.com.ghx.mainpart.home.HomeFragment;
import example.com.ghx.mainpart.home.HomeFragmentModule;
import example.com.ghx.mainpart.myfollow.MyFollowFragment;

/**
 * @author gaohx
 * @date 2018/1/10
 */
@Module
public abstract class MainPartActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {HomeFragmentModule.class})
    abstract HomeFragment homeFragment();

    @FragmentScope
    @ContributesAndroidInjector
    abstract MyFollowFragment myFollowFragment();
}
