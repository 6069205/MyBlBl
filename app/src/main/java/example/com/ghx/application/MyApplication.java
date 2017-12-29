package example.com.ghx.application;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 *
 * @author gaohx
 * @date 2017/12/19
 */

public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    private Toast mToast;

    @Override
    public void onCreate() {
        super.onCreate();
        MobclickAgent.setCatchUncaughtExceptions(true);
        CrashHandler crashHandler=CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());

        //TODO 貌似说Application的onCreate中，初始化操作也不宜过多，否
               //则会影响启动速度，不一定全在这里做初始化。目前初始化操作还少，无所谓.
               //而且还要具体看这些初始化操作，是不是很耗时.
        //推送设置
        initPush();
        //日志框架初始化
        Logger.addLogAdapter(new AndroidLogAdapter());

        mApplicationComponent=DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    /**
     * 获取ApplicationComponent
     * @return
     */
    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
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

    /**
     * 显示吐丝
     * @param text
     */
    public void showToast(String text){
        if(mToast==null){
            mToast=Toast.makeText(this,text,Toast.LENGTH_SHORT);
        }else{
            mToast.setText(text);
        }
        mToast.show();
    }
}
