package example.com.ghx.dgtest;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gnnt on 2017/9/8.
 */
@Singleton
public class BObject {
    private TestObject b;
    @Inject
    public BObject(TestObject b){
        this.b=b;
    }
//
//    @Inject
//    public BObject(){
//    }
}
