package example.com.ghx.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author gaohx
 * @date 2018/1/10
 */
@Scope
@Retention(RUNTIME)
@Documented
public @interface SubFragmentScope {
}
