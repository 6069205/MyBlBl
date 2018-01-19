package example.com.ghx.mainpart.home.recommend;

import dagger.Binds;
import dagger.Module;

/**
 * @author gaohx
 * @date 2018/1/12
 */
@Module
public abstract class RecommendModule {
    @Binds
    abstract RecommendContract.Presenter presenter(RecommendPresenter recommendPresenter);
}
