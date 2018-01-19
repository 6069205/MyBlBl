package example.com.ghx.mainpart.home;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import example.com.ghx.di.SubFragmentScope;
import example.com.ghx.mainpart.home.followplay.FollowPlayFragment;
import example.com.ghx.mainpart.home.live.LiveFragment;
import example.com.ghx.mainpart.home.recommend.RecommendFragment;
import example.com.ghx.mainpart.home.recommend.RecommendModule;
import example.com.ghx.mainpart.home.specailcolumn.SpecialColumnFragment;

/**
 * @author gaohx
 * @date 2018/1/10
 */
@Module
public abstract class HomeFragmentModule {
    @SubFragmentScope
    @ContributesAndroidInjector
    abstract FollowPlayFragment followPlayFragment();

    @SubFragmentScope
    @ContributesAndroidInjector
    abstract LiveFragment liveFragment();

    @SubFragmentScope
    @ContributesAndroidInjector(modules = {RecommendModule.class})
    abstract RecommendFragment recommendFragment();

    @SubFragmentScope
    @ContributesAndroidInjector
    abstract SpecialColumnFragment specialColumnFragment();
}
