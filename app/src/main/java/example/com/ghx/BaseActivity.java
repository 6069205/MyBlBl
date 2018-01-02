package example.com.ghx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;

import example.com.ghx.application.MyApplication;

/**
 *
 * @author gaohx
 * @date 2017/12/19
 */
public class BaseActivity extends AppCompatActivity {


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
        if(getApplication() instanceof MyApplication){
            MyApplication app= (MyApplication) getApplication();
            app.showToast(text);
        }
    }
}
