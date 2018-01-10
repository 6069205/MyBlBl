package example.com.ghx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import example.com.ghx.application.MyApplication;

/**
 *
 * @author gaohx
 * @date 2017/12/19
 */
public class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    protected Toast mToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    /**
     * 显示吐司
     * @param text
     */
    public void showToast(String text){
        mToast.setText(text);
        mToast.show();
    }
}
