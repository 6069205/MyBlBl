package example.com.ghx.mainpart.home.recommend;

import example.com.ghx.DataCallback;
import example.com.ghx.entity.HomeRecommendInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 首页推荐相关的数据仓库
 * @author gaohx
 * @date 2017/12/19
 */
public class RecommendDataRepository {

    /*官方的结构有点乱，把3级缓存都单独提出来的话，类又会增加很多，所以我决定这里暂时
     把3级缓存的实现都写在Repository内。*/

    /**
     * 主页推荐信息
     */
    private HomeRecommendInfo mHomeRecommendInfo;


//    public void set...(){}

    /**
     * 从缓存获取推荐信息
     */
    public HomeRecommendInfo getRecommendInfoFromCache() {
        return mHomeRecommendInfo;
    }

    /**
     * 从网络获取推荐信息
     * @return
     */
    public HomeRecommendInfo getRecommendInfoFromRemote(DataCallback<HomeRecommendInfo> callBack) {
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

        return null;
    }
}
