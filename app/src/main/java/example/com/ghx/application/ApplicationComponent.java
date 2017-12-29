package example.com.ghx.application;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 * @author gaohx
 * @date 2017/12/19
 */
@Component(modules={ApplicationModule.class})
@Singleton
public interface ApplicationComponent {
    /**
     * inject方法
     * @param o
     */
    void inject(Object o);
}
