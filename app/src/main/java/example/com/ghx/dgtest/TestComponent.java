package example.com.ghx.dgtest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gnnt on 2017/9/8.
 */
@Singleton
@Component
public interface TestComponent {
    void inject(MainObject mainObject);
}
