package example.com.ghx.mainpart.home.recommend;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import example.com.ghx.di.SubFragmentScope;

/**
 * @author gaohx
 * @date 2018/1/12
 */
@Module
public class RecommendModule {
//    @Binds
//    abstract RecommendContract.Presenter recommendPresenter(RecommendPresenter recommendPresenter);

//    @Named("SB")
//    @Provides
//    public RecommendContract.Presenter provideRecommendPresenter(RecommendPresenter recommendPresenter){
//        return recommendPresenter;
//    }

    @Provides
    public String str(){
        return "我擦";
    }
}
