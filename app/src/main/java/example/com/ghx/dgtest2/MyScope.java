package example.com.ghx.dgtest2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by gnnt on 2017/10/13.
 */

@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface MyScope {
}
