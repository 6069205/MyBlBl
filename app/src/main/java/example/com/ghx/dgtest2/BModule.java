package example.com.ghx.dgtest2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gnnt on 2017/9/26.
 */
@Module
public class BModule {
//    @Singleton
    @MyScope
    @Provides
    public BClass provideBClass(){
        return new BClass();
    }
}
