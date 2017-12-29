package example.com.ghx.application;
import android.content.Context;
import android.util.Log;

import com.umeng.analytics.MobclickAgent;

/**
 *
 * @author gaohx
 * @date 2017/12/19
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /**
     * 必须是Application的context(否则单例里面保存其它Activity的context会内存泄漏)
     */
    private Context mContext;

    /**
     * 系统默认的CrashHandler
     */
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private volatile static CrashHandler mInstance;

    private CrashHandler() {

    }

    public static CrashHandler getInstance() {
        if (mInstance == null) {
            synchronized (CrashHandler.class) {
                if (mInstance == null) {
                    mInstance = new CrashHandler();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化
     * @param context
     */
    public void init(Context context) {
        mContext=context;
        //保存一份系统默认的CrashHandler
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //使用我们自定义的异常处理器替换默认的处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        //将CrashHandler设置成异常处理器后，应用内没有catch到的异常都会拿到这里来处理
        if(throwable!=null){
            handleException(throwable);
//            mDefaultHandler.uncaughtException(thread,throwable);
        }
        //处理完未捕获的异常之后,这里是直接杀死进程
        MobclickAgent.onKillProcess(mContext);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    /**
     * 自定义处理异常的方法
     * @param throwable
     */
    private void handleException(Throwable throwable){
        //上传异常信息到友盟
        MobclickAgent.reportError(mContext, throwable);
        //Log输出异常信息
        Log.e("CrashHandler",Log.getStackTraceString(throwable));
    }
}
