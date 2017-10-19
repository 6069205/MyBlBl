package example.com.ghx;

import android.Manifest;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.sample_text)
    TextView sampleText;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    /**
     * 获取WIFI服务
     */
    WifiManager wifiManager;

//    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        wifiManager=(WifiManager)super.getSystemService(Context.WIFI_SERVICE);

//        ActivityCompat.requestPermissions();
//        requestPermissions();
//        checkSelfPermission();
//        ActivityCompat.requestPermissions();
        int check=ActivityCompat.checkSelfPermission(this, Manifest.permission.CHANGE_WIFI_STATE);
        if(check==android.content.pm.PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"有WIFI修改",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"没有WIFI修改权限",Toast.LENGTH_SHORT).show();
        }

        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());

        sampleText.setText("哈哈哈哈");

        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = null;
                    url = new URL("https://www.baidu.com/");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    //返回打开连接读取的输入流
                    InputStream is = conn.getInputStream();
                    //判断是否正常响应数据
                    if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                        System.out.println("网络错误异常！!!!");
                        return;
                    }
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String firstLineStr = br.readLine();
                    System.out.println("第一行数据：" + firstLineStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @OnClick(R.id.sample_text)
    public void onViewClicked() {

        if(wifiManager.getWifiState()==WifiManager.WIFI_STATE_ENABLED){
            Toast.makeText(this,"关闭wifi",Toast.LENGTH_SHORT).show();
        }else{
            boolean bool=wifiManager.setWifiEnabled(true);
            Toast.makeText(this,"开启wifi:"+bool,Toast.LENGTH_SHORT).show();
        }

    }

    //    /**
//     * A native method that is implemented by the 'native-lib' native library,
//     * which is packaged with this application.
//     */
//    public native String stringFromJNI();
}
