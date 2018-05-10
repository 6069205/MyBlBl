package example.com.ghx.mainpart.home.recommend;

import javax.inject.Inject;

import example.com.ghx.DataCallback;
import example.com.ghx.entity.RecommendInfo;
import io.reactivex.annotations.NonNull;

/**
 * @author gaohx
 * @date 2017/12/29
 */

public class RecommendPresenter implements RecommendContract.Presenter{

    RecommendContract.View mView;

    @Inject
    RecommendDataRepository mDataRepository;

    @Inject
    public RecommendPresenter(){
    }

    @Override
    public void getRecommendFromRemote() {
        mDataRepository.getRecommendFromRemote(
                new DataCallback<RecommendInfo>() {
            @Override
            public void onDataAvailable(RecommendInfo recommendInfo) {
                //获取到主页推荐信息后，更新页面列表
                mView.updateList(recommendInfo);
            }

            @Override
            public void onDataNotAvailable(Throwable e) {
                //暂时简单写个提示
                mView.showMessage("请求主页推荐信息失败");
            }
        });
    }

    @Override
    public RecommendInfo getRecommendFromCache() {
        return mDataRepository.getRecommendFromCache();
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
