package example.com.ghx.dgtest2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gnnt on 2017/9/25.
 */
@Module
public class ThirdPartModule {

    @Provides
    public ThirdPartClass provideThirdPart(BClass bObject){
        return new ThirdPartClass(bObject);
    }
}
