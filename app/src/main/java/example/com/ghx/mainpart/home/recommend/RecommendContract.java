package example.com.ghx.mainpart.home.recommend;

import example.com.ghx.base.BasePresenter;
import example.com.ghx.base.BaseView;
import example.com.ghx.entity.RecommendInfo;

/**
 * @author gaohx
 * @date 2018/1/2
 */

public interface RecommendContract {
    interface Presenter extends BasePresenter<View>{
        /**请求主页推荐信息*/
        void getRecommendFromRemote();

        /**获取缓存中现有的主页推荐信息*/
        RecommendInfo getRecommendFromCache();
    }

    interface View extends BaseView<Presenter>{
        /**
         * 更新列表
         * @param recommendInfo
         */
        void updateList(RecommendInfo recommendInfo);

        /**
         * 显示提示信息
         * @param message
         */
        void showMessage(String message);
    }
}
