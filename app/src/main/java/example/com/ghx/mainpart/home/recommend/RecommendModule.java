package example.com.ghx.mainpart.home.recommend;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 也可以是接口。这得看你要不要加已实现的方法了
 * @author gaohx
 * @date 2018/1/2
 */
@Module
public abstract class RecommendModule {

    //TODO 现在这里只是依葫芦画瓢搞出来的，还要参考官方文档，参考官方demo，参考网上

    @ContributesAndroidInjector
    abstract RecommendFragment recommendFragment();

    @Binds
    abstract RecommendContract.Presenter recommendPresenter(RecommendPresenter presenter);
}
