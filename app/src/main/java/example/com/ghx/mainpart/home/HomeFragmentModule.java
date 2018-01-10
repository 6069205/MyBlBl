package example.com.ghx.mainpart.home;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import example.com.ghx.di.SubFragmentScope;
import example.com.ghx.mainpart.home.followplay.FollowPlayFragment;
import example.com.ghx.mainpart.home.live.LiveFragment;
import example.com.ghx.mainpart.home.recommend.RecommendFragment;
import example.com.ghx.mainpart.home.specailcolumn.SpecialColumnFragment;

/**
 * @author gaohx
 * @date 2018/1/10
 */
@Module
public interface HomeFragmentModule {
    @SubFragmentScope
    @ContributesAndroidInjector
    FollowPlayFragment followPlayFragment();

    @SubFragmentScope
    @ContributesAndroidInjector
    LiveFragment liveFragment();

    @SubFragmentScope
    @ContributesAndroidInjector
    RecommendFragment recommendFragment();

    @SubFragmentScope
    @ContributesAndroidInjector
    SpecialColumnFragment specialColumnFragment();
}
