package example.com.ghx.mainpart.home.recommend;

import example.com.ghx.entity.HomeRecommendInfo;

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
        //TODO 这里开始
        return null;
    }
}
