package example.com.ghx.mainpart.home.recommend;

import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * @author gaohx
 * @date 2017/12/29
 */

public class RecommendPresenter implements RecommendContract.Presenter{

    public RecommendDataRepository mDataRepository;

    @Inject
    public RecommendPresenter(@NonNull RecommendDataRepository dataRepository){
        mDataRepository=dataRepository;
    }

    @Override
    public void getList() {

    }

    @Override
    public void addView(RecommendContract.View view) {

    }

    @Override
    public void removeView() {

    }
}
