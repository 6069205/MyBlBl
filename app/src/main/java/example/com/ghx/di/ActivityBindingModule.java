package example.com.ghx.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import example.com.ghx.mainpart.MainPartActivity;
import example.com.ghx.mainpart.MainPartActivityModule;
import example.com.ghx.welcome.WelcomeActivity;

/**
 * @author gaohx
 * @date 2018/1/10
 */
@Module
public interface ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {MainPartActivityModule.class})
    MainPartActivity mainPartActivity();

    @ActivityScope
    @ContributesAndroidInjector
    WelcomeActivity welcomeActivity();
}
