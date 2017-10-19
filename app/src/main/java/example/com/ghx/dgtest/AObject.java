package example.com.ghx.dgtest;


import javax.inject.Inject;

/**
 * Created by gnnt on 2017/9/8.
 */

public class AObject {
    private TestObject a;
    @Inject
    public AObject(TestObject a){
        this.a=a;
    }
}
