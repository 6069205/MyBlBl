package example.com.ghx;

import android.app.Application;
import android.util.Log;

import com.umeng.analytics.MobclickAgent;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by gnnt on 2017/8/21.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobclickAgent.setCatchUncaughtExceptions(true);
        CrashHandler crashHandler=CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());

        //推送设置
        initPush();
    }

    /**
     * 初始化推送
     */
    private void initPush() {
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.d("友盟推送注册","成功，"+deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e("友盟推送注册","失败");
            }
        });
        //统计应用启动数据(此方法与统计分析sdk中统计日活的方法无关！请务必调用此方法！)
        PushAgent.getInstance(getBaseContext()).onAppStart();
    }
}
