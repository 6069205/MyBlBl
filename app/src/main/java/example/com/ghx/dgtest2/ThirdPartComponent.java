package example.com.ghx.dgtest2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gnnt on 2017/9/25.
 */
@Component(modules = {ThirdPartModule.class,BModule.class})
//@Singleton
@MyScope
public interface ThirdPartComponent {
    void inject(NeedInjectClass need);
}
