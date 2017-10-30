package example.com.ghx.mainpart.home.recommend;

import example.com.ghx.entity.HomeRecommendInfo;

/**
 * 推荐相关的数据接口
 * Created by gaohx on 2017/10/30.
 */

public interface RecommendDataInterface {

    /**
     * 首页推荐信息获取回调
     */
    interface GetRecommendInfoCallBack{
        /**
         * 首页推荐信息加载成功
         */
        void onRecommendInfoLoaded(HomeRecommendInfo homeRecommendInfo);

        /**
         * 加载失败
         */
        void onDataNotAvailable();
    }

    /**
     * 从内存缓存获取推荐信息
     * @return
     */
    HomeRecommendInfo getRecommendInfoFromCache();

    /**
     * 从网络获取推荐信息
     * @return
     */
    HomeRecommendInfo getRecommendInfoFromRemote();
}
