package example.com.ghx.mainpart.home.recommend;

import example.com.ghx.entity.HomeRecommendInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.schedulers.Schedulers;

/**
 * 主页推荐相关的数据仓库
 * Created by gaohx on 2017/10/30.
 */

public class RecommendDataRepository implements RecommendDataInterface{
    /**
     * 主页推荐信息
     */
    private HomeRecommendInfo mHomeRecommendInfo;

    @Override
    public HomeRecommendInfo getRecommendInfoFromCache() {
        return mHomeRecommendInfo;
    }

    @Override
    public HomeRecommendInfo getRecommendInfoFromRemote() {
        //TODO 网络请求回调，重新赋值mHomeRecommendInfo，并调用执行自己操作的回调接口

        //TODO 这里开始------分析写到笔记上
        Observable<Object> o1=Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {

            }
        });

        Observable<Object> o2=o1.subscribeOn(Schedulers.io());
        Observable<Object> o3=o2.observeOn(AndroidSchedulers.mainThread());

        Observable<Object> o4=o3.map(new Function<Object, Object>() {
            @Override
            public Object apply(@NonNull Object o) throws Exception {
                return null;
            }
        });

        o4.subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Object o) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        return null;
    }
}
