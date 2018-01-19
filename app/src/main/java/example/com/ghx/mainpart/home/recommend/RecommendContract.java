package example.com.ghx.mainpart.home.recommend;

import example.com.ghx.base.BasePresenter;
import example.com.ghx.base.BaseView;

/**
 * @author gaohx
 * @date 2018/1/2
 */

public interface RecommendContract {
    interface Presenter extends BasePresenter<View>{
        /**获取列表数据*/
        void getList();
    }

    interface View extends BaseView<Presenter>{
        /**这里还要加数据列表参数*/
        void refreshList();
        /**显示提示信息*/
        void showMessage(String message);
    }
}
