package example.com.ghx.mainpart.home.recommend;

import javax.inject.Inject;
import example.com.ghx.entity.HomeRecommendInfo;

/**
 * @author gaohx
 * @date 2017/12/29
 */

public class RecommendPresenter implements RecommendContract.Presenter{

    /**
     * 主页推荐信息
     */
    private HomeRecommendInfo mHomeRecommendInfo;

    RecommendContract.View mView;

    @Inject
    RecommendDataRepository mDataRepository;

    @Inject
    public RecommendPresenter(){
    }

    @Override
    public void getList() {

    }

    @Override
    public void addView(RecommendContract.View view) {
        mView=view;
    }

    @Override
    public void removeView() {
        mView=null;
    }
}
