package example.com.ghx.application;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 *
 * @author gaohx
 * @date 2017/12/19
 */
@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context){
        this.context=context;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public Toast provideToast(){
        return Toast.makeText(context,"",Toast.LENGTH_SHORT);
    }
}
