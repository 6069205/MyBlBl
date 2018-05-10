package example.com.ghx.mainpart.home.recommend;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import example.com.ghx.DataCallback;
import example.com.ghx.entity.RecommendInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * 首页推荐相关的数据仓库
 * @author gaohx
 * @date 2017/12/19
 */
public class RecommendDataRepository {

    /**
     * 主页推荐信息缓存
     */
    private RecommendInfo mRecommendInfo=null;

    @Inject
    public RecommendDataRepository(){}

    /**
     * 从网络获取推荐信息
     * @return
     */
    public void getRecommendFromRemote(DataCallback<RecommendInfo> callBack) {
        //TODO 还要考虑要不要加http缓存
        //TODO 网络请求回调，重新赋值mHomeRecommendInfo，并调用执行自己操作的回调接口
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

        //Observer继承DisposableObserver
    }

    /**
     * 获取缓存的推荐信息(注意这里并不是从单例获取缓存)
     * @return
     */
    public @Nullable RecommendInfo getRecommendFromCache() {
        return mRecommendInfo;
    }

    /*public void getRecommendInfoFromDisk
    可以像官方demo那样进行3层缓存的抽象，有需要再来改*/

    /*至于是要取缓存，还是从网络请求，由p层控制*/
}
