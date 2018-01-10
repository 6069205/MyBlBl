package example.com.ghx.application;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import example.com.ghx.di.ActivityBindingModule;

/**
 *
 * @author gaohx
 * @date 2017/12/19
 */
@Component(modules={ApplicationModule.class
        , ActivityBindingModule.class
        , AndroidSupportInjectionModule.class})
@Singleton
public interface ApplicationComponent extends AndroidInjector<MyApplication>{

}
